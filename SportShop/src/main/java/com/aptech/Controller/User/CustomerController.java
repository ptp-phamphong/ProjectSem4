package com.aptech.Controller.User;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.aptech.Dao.CustomerDao;
import com.aptech.Model.Customer;
import com.aptech.MyClass.HashPassword;


@Controller
public class CustomerController {

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView showViewRegister(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/register");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/sendEmailRegister" }, method = RequestMethod.POST)
	public String sendEmail(@RequestBody String mailUser) {
		
		
		return "aa";
	}
	
	
	@RequestMapping(value = { "/registerHandelling" }, method = RequestMethod.POST)
 	public ModelAndView registerHandelling(@ModelAttribute("customer")Customer item, RedirectAttributes redir, HttpServletRequest request) {
		HashPassword hashPassword = new HashPassword();
		item.setPassword(hashPassword.getPassInMD5(item.getPassword()));
		CustomerDao customerDao = new CustomerDao();
		ModelAndView modelAndView= new ModelAndView("user/validate");
		
		if(!customerDao.addNew(item)) {
			redir.addAttribute("Error", "Please check again");
			modelAndView = new ModelAndView("user/register");
		}
		return modelAndView;
	}

	
	
	
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView showViewLogin(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/login");
		return mv;
	}
	
	@RequestMapping(value= {"/loginHandelling"}, method = RequestMethod.POST)
	public RedirectView loginHandelling(@ModelAttribute("customer") Customer item, RedirectAttributes redir, HttpServletRequest request) {
		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer();
		
		//Chuyển qua MD5
		HashPassword HashPassword = new HashPassword();
		String passMD5 = HashPassword.getPassInMD5(item.getPassword());
		
		customer = customerDao.getAccountLogin(item.getEmail(), passMD5);
		
		if(customer == null) {
			RedirectView redirectView = new RedirectView("/login", true); 
			
			redir.addFlashAttribute("customer", new Customer());
			
			redir.addFlashAttribute("Error","Wrong username or password, please try again");
			return redirectView;
		}
		
		
		RedirectView redirectView = new RedirectView("/category", true);
		request.getSession().setAttribute("currentCustomer", customer);
		
		//redir.addFlashAttribute("currentCustomer", customer);
		return redirectView;
	}
	
}
