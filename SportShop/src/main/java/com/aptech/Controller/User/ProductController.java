package com.aptech.Controller.User;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.ProductDao;
import com.aptech.Dao.ProductDetailDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;
import com.aptech.Model.Product;
import com.aptech.Model.ProductDetail;
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
		
	@RequestMapping(value = { "/{productType}/{sportType}/{productID:\\d+}", "/{productType}/{sportType}/{productID:\\d+}/**" }, method = RequestMethod.GET)
	// \d:+ chỉ nhận giá trị int
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
	
	
	//Các hàm xử lý giỏ hàng
	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
	public ModelAndView showCart(Model model, HttpServletRequest request) {
		model.addAttribute("customer", new Customer());	
		
		ModelAndView mv = new ModelAndView("user/cart");
		return mv;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = { "/addItemToCart" }, method = RequestMethod.POST)
	public String addItemToCart( HttpServletRequest request) {
		int idProduct = Integer.parseInt(request.getParameter("idProduct"));
		ProductDetailDao productDetailDao = new ProductDetailDao();
		ProductDetail productToCart = new ProductDetail();
		
		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("curCart");
		
		//Xét xem người đó có nhập số lượng vào ko
		int quantity = 1;
		if(request.getAttribute("quantity") != null)
			quantity =  Integer.parseInt(request.getAttribute("quantity").toString());
		
		//Xét xem người dùng họ thêm sản phẩm size ở thứ tự nào
		int numOfSize = 0;
		if(request.getAttribute("size") != null)
			numOfSize =  Integer.parseInt(request.getAttribute("size").toString());
		productToCart =  productDetailDao.getByIdProduct(idProduct).get(numOfSize);
		
		if(curCart == null) {//Nếu trong cart chưa có gì
			curCart = new ArrayList<Cart>();//Khởi tạo mới được
			Cart newItem = new Cart();
			newItem.setQuantity(quantity);
			newItem.setPrice(productToCart.getPrice());
			newItem.setProductDetail(productToCart);
			newItem.setProductDetailsID(productToCart.getId());
			curCart.add(newItem);
			session.setAttribute("curCart", curCart);
			return "done";
		}
		
		
		//Nếu trong cart có gì đó rồi, thì phải xét xem món đó đã từng nằm trong cart chưa, nếu có thì chỉ tăng số lượng lên quantity thôi
		for(int i=0;i<curCart.size();i++) {
			if(productToCart.getId() == curCart.get(i).getProductDetailsID()) {//Nếu từng có rồi
				curCart.get(i).setQuantity(curCart.get(i).getQuantity() + quantity);
				session.setAttribute("curCart", curCart);
				return "done";
			}
		}
		
		//Nếu đây là 1 món hoàn toàn mới
		Cart newItem = new Cart();
		newItem.setQuantity(quantity);
		newItem.setPrice(productToCart.getPrice());
		newItem.setProductDetail(productToCart);
		newItem.setProductDetailsID(productToCart.getId());
		curCart.add(newItem);
		session.setAttribute("curCart", curCart);
		
		
		return "done";
	}
	
	
	//Hàm Ajax tăng số lượng trong giỏ hàng
	@ResponseBody
	@RequestMapping(value = { "/ajax/increseQuantity" }, method = RequestMethod.POST)
	public ModelAndView increseQuantity( HttpServletRequest request) {
		int idProductDetail = Integer.parseInt(request.getParameter("idProductDetail"));
		
		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("curCart");
		
		for(int i=0;i<curCart.size();i++) {
			if(curCart.get(i).getProductDetail().getId() == idProductDetail) {
				curCart.get(i).setQuantity(curCart.get(i).getQuantity() + 1);
				break;
			}
		}
		
		ModelAndView mv = new ModelAndView("user/cartDetail");
		return mv;
	}
	
	
	//Hàm ajax, giảm số lượng trong giỏ hàng
	@ResponseBody
	@RequestMapping(value = { "/ajax/decreaseQuantity" }, method = RequestMethod.POST)
	public ModelAndView decreaseQuantity( HttpServletRequest request) {
		int idProductDetail = Integer.parseInt(request.getParameter("idProductDetail"));
		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("curCart");
		
		for(int i=0;i<curCart.size();i++) {
			if(curCart.get(i).getProductDetail().getId() == idProductDetail) {
				if(curCart.get(i).getQuantity() == 1) //Nếu số lượng là 1 rồi mà còn muốn giảm thì dell cho giảm
					break;
				curCart.get(i).setQuantity(curCart.get(i).getQuantity() - 1);
				break;
			}
		}
		
		ModelAndView mv = new ModelAndView("user/cartDetail");
		return mv;
	}
	
	
	
	
	//Hết hàm rồi đấy, đmẹ đáng lẽ nên xài cái service
	
	
	
	
	
}
