package com.aptech.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.ProductDao;
import com.aptech.Model.Customer;

@Controller
public class HomeController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView showViewIndex(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/index");
		return mv;
	}
	

	@RequestMapping(value = { "/category" }, method = RequestMethod.GET)
	public ModelAndView product(Model model) {
		ProductDao productDao = new ProductDao();
		int a = productDao.getAll().size();
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/category");
		mv.addObject("list", productDao.getAll());

		return mv;
	}
}
