package com.aptech.Controller.User;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.ProductDao;
import com.aptech.Dao.ProductDetailDao;
import com.aptech.Dao.SizeDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;
import com.aptech.Model.Product;
import com.aptech.Model.ProductDetail;
import com.aptech.Model.Size;
import com.aptech.MyClass.SendingEmail;

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

	@RequestMapping(value = { "/{productType}/{sportType}/{productID:\\d+}",
			"/{productType}/{sportType}/{productID:\\d+}/**" }, method = RequestMethod.GET)
	// \d:+ chỉ nhận giá trị int
	public ModelAndView showProductDetails(Model model, HttpServletRequest request , @PathVariable("productID") int productID) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/product");
		
		// Lấy ra các productDetails thuộc về sản phẩm này để hiển thị bên view
		ArrayList<ProductDetail> listProductDetails = new ArrayList<ProductDetail>();
		ProductDetailDao productDetailDao = new ProductDetailDao();
		listProductDetails = productDetailDao.getByIdProduct(productID);
		mv.addObject("listProductDetails", listProductDetails);

		mv.addObject("item", productDao.getByProductID(productID));
		mv.addObject("nextProduct", productDao.getByProductID(productID + 1));
		if (productID == 1) {
			mv.addObject("prevProduct", productDao.getLastProduct());
		} else {
			mv.addObject("prevProduct", productDao.getByProductID(productID - 1));
		}
		return mv;
	}

	

}
