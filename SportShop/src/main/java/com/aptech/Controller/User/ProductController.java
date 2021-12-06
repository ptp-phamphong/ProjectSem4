package com.aptech.Controller.User;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.ProductDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;

@Controller
public class ProductController {

	@RequestMapping(value = { "/category" }, method = RequestMethod.GET)
	public ModelAndView showCategory(Model model) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/category");
		mv.addObject("list", productDao.getAll());

		return mv;
	}
	
	
	
	@RequestMapping(value = { "/category/productList" }, method = RequestMethod.GET)
	public ModelAndView showProductList(Model model) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/productList");
		
		mv.addObject("listProduct", productDao.getAll());

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
	
	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
	public ModelAndView showCart(Model model) {
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/cart");
		ArrayList<Cart> cartList = new ArrayList();//TEST sau thay bang session
		cartList.add(new Cart(1, 2, 10));
		cartList.add(new Cart(2, 1, 15));
		mv.addObject("cartList", cartList);
		return mv;
	}
}
