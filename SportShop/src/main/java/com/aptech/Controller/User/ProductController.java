package com.aptech.Controller.User;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.ProductDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;

@Controller
public class ProductController {
	
	@RequestMapping(value = { "/all-product" }, method = RequestMethod.GET)
	public ModelAndView showProductList(Model model) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/productList");
		
		mv.addObject("listProduct", productDao.getAll());

		return mv;
	}
		
	@RequestMapping(value = { "/{productType}/{sportType}/{productID:\\d+}", "/{productType}/{sportType}/{productID:\\d+}/**" }, method = RequestMethod.GET)
	public ModelAndView showProductDetails(Model model, @PathVariable("productID") int productID) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());	
		ModelAndView mv = new ModelAndView("user/product");
		mv.addObject("productDetails", productDao.getByProductID(productID));
		mv.addObject("nextProduct", productDao.getByProductID(productID+1));
		if (productID == 1) {
			mv.addObject("prevProduct", productDao.getLastProduct());
		}else {
			mv.addObject("prevProduct", productDao.getByProductID(productID-1));
		}
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
