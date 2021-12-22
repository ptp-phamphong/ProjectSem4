package com.aptech.Controller.User;

import java.net.http.HttpRequest;
import java.util.Random;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.CustomerDao;
import com.aptech.Dao.ImageDao;
import com.aptech.Dao.ProductDao;
import com.aptech.Dao.ProductDetailDao;
import com.aptech.Dao.StaffDao;
import com.aptech.Model.Customer;
import com.aptech.Model.Staff;
import com.aptech.MyClass.HashPassword;
import com.aptech.MyClass.SendingEmail;


@Controller
public class CustomerController {

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView showViewRegister(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/register");
		CategoryDao categoryDao = new CategoryDao();
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/sendEmailRegister" }, method = RequestMethod.POST)
	public String sendEmail( HttpServletRequest request) {
		SendingEmail sendingEmail = new SendingEmail();
		Random rand = new Random();
		int OTPCode = rand.nextInt(10000)+10000;
		if(sendingEmail.sendEmail("OTP Code", "Your OTP Code is: " + OTPCode, request.getParameter("email"))) {
			request.getSession().setAttribute("OTPCode", OTPCode);
			return "Please type Your Code";
			
		}
		return "Wrong Email, please input again";
	}
	
	
	@RequestMapping(value = { "/registerHandelling" }, method = RequestMethod.POST)
 	public ModelAndView registerHandelling(@ModelAttribute("customer")Customer item,@RequestParam("OTPCode") int OTPCode, RedirectAttributes redir, HttpServletRequest request) {
		int ROCode = (Integer) (request.getSession().getAttribute("OTPCode"));
		ModelAndView modelAndView= new ModelAndView("user/login");
		if(OTPCode != ROCode) {
			modelAndView.addObject("Error", "Please check your OTP Code");
			modelAndView = new ModelAndView("user/register");
		}
		
		
		HashPassword hashPassword = new HashPassword();
		item.setPassword(hashPassword.getPassInMD5(item.getPassword()));
		CustomerDao customerDao = new CustomerDao();
		
		if(!customerDao.addNew(item)) {
			modelAndView.addObject("Error", "Please check your OTP Code");
			modelAndView = new ModelAndView("user/register");
		}
		
		modelAndView.addObject("Error","Congratulation, Please Login To Continue");
		return modelAndView;
	}

	@RequestMapping(value = { "admin/loginAdmin" }, method = RequestMethod.GET)
	public ModelAndView loginAdmin(Model model) {
		model.addAttribute("staff", new Staff());
		ModelAndView mv = new ModelAndView("admin/loginAdmin");
		return mv;
	}
	
	@RequestMapping(value = { "admin/customerList" }, method = RequestMethod.GET)
	public ModelAndView customerList(Model model) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		model.addAttribute("staff", new Staff());
		CustomerDao cusDao = new CustomerDao();
		model.addAttribute("accountList", cusDao.getAll());
		ModelAndView mv = new ModelAndView("admin/customerAccountList");
		
		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());
		
		return mv;
	}
	
	@RequestMapping(value = { "admin/staffAccountList" }, method = RequestMethod.GET)
	public ModelAndView staffAccountList(Model model) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		model.addAttribute("staff", new Staff());
		StaffDao staffDao = new StaffDao();
		model.addAttribute("accountList", staffDao.getAll());
		ModelAndView mv = new ModelAndView("admin/staffAccountList");
		
		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());
		
		return mv;
	}
	
	@RequestMapping(value = { "/admin/customerDetail/{id}" }, method = RequestMethod.GET)
	public ModelAndView exportProduct(Model model, @PathVariable("id") int id) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		CustomerDao cusDao = new CustomerDao();
		
		ModelAndView mv = new ModelAndView("admin/customerDetail");
		mv.addObject("Customer", cusDao.getAccount(id));
		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());
		
		return mv;
	}

	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView showViewLogin(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/login");
		CategoryDao categoryDao = new CategoryDao();
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
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
		
		
		RedirectView redirectView = new RedirectView("/all-product", true);
		request.getSession().setAttribute("currentCustomer", customer);
		
		//redir.addFlashAttribute("currentCustomer", customer);
		return redirectView;
	}
	
	@RequestMapping(value= {"/logoutHandelling"})
	public RedirectView logoutHandelling(RedirectAttributes redir, HttpServletRequest request) {
		
		RedirectView redirectView = new RedirectView("/all-product", true);
		HttpSession session = request.getSession();
		session.invalidate();
		
		//redir.addFlashAttribute("currentCustomer", customer);
		return redirectView;
	}
	
	@RequestMapping(value = { "/account/{id}" }, method = RequestMethod.GET)
	public ModelAndView showViewAccount(@PathVariable int id) {
		CustomerDao customerDAO = new CustomerDao();	
		ModelAndView mv = new ModelAndView("user/account");
		mv.addObject("customer", customerDAO.getAccount(id));
		CategoryDao categoryDao = new CategoryDao();
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = { "/editStatus" }, method = RequestMethod.GET)
	public void editStatus(@RequestParam int acc) {
		
		CustomerDao cusDao = new CustomerDao();
		Customer cus = cusDao.getAccount(acc);
		if(cus.getStatus()) {
			cusDao.turnOff(acc);
		}
		else {
			cusDao.turnOn(acc);
		}	
	}
	
	@ResponseBody
	@RequestMapping(value = { "/deleteAccount" }, method = RequestMethod.GET)
	public void deleteAccount(@RequestParam int acc) {
		CustomerDao cusDao = new CustomerDao();
		cusDao.delete(acc);
	}
}
