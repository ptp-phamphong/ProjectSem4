package com.aptech.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.ProductDao;
import com.aptech.Model.Customer;

@Controller
public class ProductController {

	@RequestMapping(value = { "/category" }, method = RequestMethod.GET)
	public ModelAndView showProductListing(Model model) {
		ProductDao productDao = new ProductDao();
		int a = productDao.getAll().size();
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/category");
		mv.addObject("list", productDao.getAll());

		return mv;
	}
	
	@RequestMapping(value = { "/category/product" }, method = RequestMethod.GET)
	public ModelAndView showProductDetails(Model model) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/product");
		mv.addObject("list", productDao.getAll());
		return mv;
	}
	
}
