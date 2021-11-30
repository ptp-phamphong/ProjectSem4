package com.aptech.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.CustomerDao;
import com.aptech.Model.Customer;
import com.aptech.MyClass.HashPassword;

@Controller
public class CustomerController {

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register() {
		return ("user/register");
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView showViewLogin(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/login");
		return mv;
	}
	
	@RequestMapping(value= {"/loginHandelling"}, method = RequestMethod.POST)
	public ModelAndView loginHandelling(@ModelAttribute("customer") Customer item, ModelMap modelMap, Model model) {
		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer();
		
		//Chuyển qua MD5
		HashPassword HashPassword = new HashPassword();
		String passMD5 = HashPassword.getPassInMD5(item.getPassword());
		
		customer = customerDao.getAccountLogin(item.getEmail(), passMD5);
		ModelAndView mv = new ModelAndView();
		if(customer == null) {
			model.addAttribute("customer", new Customer());
			model.addAttribute("Error","Wrong username or password, please try again");
			mv.setViewName("user/login");
			return mv;
		}
		
		
		mv.setViewName("user/index");
		mv.addObject("currentCustomer", customer);
		return mv;
	}
	
}
