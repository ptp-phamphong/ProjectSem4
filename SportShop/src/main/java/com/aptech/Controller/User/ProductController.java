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
		
		System.out.print("abc123");
		
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

	// Các hàm xử lý giỏ hàng

	// Hiện ra giỏ hàng
	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
	public ModelAndView showCart(Model model, HttpServletRequest request) {
		model.addAttribute("customer", new Customer());

		ModelAndView mv = new ModelAndView("user/cart");
		return mv;
	}

	// Thêm sản phẩm vào giỏ hàng ở trang danh sách toàn bộ sản phẩm
	@ResponseBody
	@RequestMapping(value = { "/ajax/addItemToCart" }, method = RequestMethod.POST)
	public ModelAndView addItemToCart(HttpServletRequest request) {
		ProductDetailDao productDetailDao = new ProductDetailDao();
		ProductDetail productToCart = new ProductDetail();
		int quantity = 1;

		if (!Boolean.parseBoolean(request.getParameter("inDetails"))) {
			productToCart = productDetailDao.getByIdProduct(Integer.parseInt(request.getParameter("idProduct"))).get(0);
		}

		if (Boolean.parseBoolean(request.getParameter("inDetails"))) {
			quantity = Integer.parseInt(request.getParameter("quantity").toString());
			productToCart = productDetailDao.getById(Integer.parseInt(request.getParameter("idProductDetails")));
		}

		addItemToCartHandelling(productToCart, quantity, request);
		ModelAndView mv = new ModelAndView("/layouts/user/headerCart");
		return mv;
	}

	// Thêm sản phẩm vào giỏ hàng ở chi tiết sản phẩm
	@ResponseBody
	@RequestMapping(value = { "/ajax/addItemToCartInDetail" }, method = RequestMethod.GET)
	public String addItemToCartInDetail(@ModelAttribute Customer customer, BindingResult bindingResult,HttpServletRequest request) {
		ProductDetailDao productDetailDao = new ProductDetailDao();
		ProductDetail productToCart = new ProductDetail();
		int quantity = Integer.parseInt(request.getParameter("quantity").toString());
		productToCart = productDetailDao.getById(Integer.parseInt(request.getParameter("idProduct")));

		addItemToCartHandelling(productToCart, quantity, request);

		return "done";
	}

	
	
	// Hàm Ajax tăng số lượng trong giỏ hàng
	@ResponseBody
	@RequestMapping(value = { "/ajax/increseQuantity" }, method = RequestMethod.POST)
	public ModelAndView increseQuantity(HttpServletRequest request) {
		int idProductDetail = Integer.parseInt(request.getParameter("idProductDetail"));

		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("curCart");

		for (int i = 0; i < curCart.size(); i++) {
			if (curCart.get(i).getProductDetail().getId() == idProductDetail) {
				curCart.get(i).setQuantity(curCart.get(i).getQuantity() + 1);
				break;
			}
		}

		ModelAndView mv = new ModelAndView("user/cartDetail");
		return mv;
	}

	// Hàm ajax, giảm số lượng trong giỏ hàng
	@ResponseBody
	@RequestMapping(value = { "/ajax/decreaseQuantity" }, method = RequestMethod.POST)
	public ModelAndView decreaseQuantity(HttpServletRequest request) {
		int idProductDetail = Integer.parseInt(request.getParameter("idProductDetail"));
		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("curCart");

		for (int i = 0; i < curCart.size(); i++) {
			if (curCart.get(i).getProductDetail().getId() == idProductDetail) {
				if (curCart.get(i).getQuantity() == 1) // Nếu số lượng là 1 rồi mà còn muốn giảm thì dell cho giảm
					break;
				curCart.get(i).setQuantity(curCart.get(i).getQuantity() - 1);
				break;
			}
		}

		ModelAndView mv = new ModelAndView("user/cartDetail");
		return mv;
	}

	// Hàm ajax, xóa 1 phần tử khỏi giỏ hàng
	@ResponseBody
	@RequestMapping(value = { "/ajax/removeItemCart" }, method = RequestMethod.POST)
	public ModelAndView removeItemCart(HttpServletRequest request) {
		int idProductDetail = Integer.parseInt(request.getParameter("idProductDetail"));
		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("curCart");

		for (int i = 0; i < curCart.size(); i++) {
			if (curCart.get(i).getProductDetail().getId() == idProductDetail) {
				curCart.remove(i);
				break;
			}
		}

		ModelAndView mv = new ModelAndView("user/cartDetail");
		return mv;
	}

	
	//Trả về header Cart để in ra.
	@ResponseBody
	@RequestMapping(value = { "/ajax/showHeaderCart" }, method = RequestMethod.POST)
	public ModelAndView showHeaderCart(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("/layouts/user/headerCart");
		return mv;
	}
	
	// Hết hàm rồi đấy, đmẹ đáng lẽ nên xài cái service

	
	
	
	
	
	
	// Các hàm tự viết
	private void addItemToCartHandelling(ProductDetail productToCart, int quantity, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("curCart");

		if (curCart == null) {// Nếu trong cart chưa có gì
			curCart = new ArrayList<Cart>();// Khởi tạo mới được
			Cart newItem = new Cart();
			newItem.setQuantity(quantity);
			newItem.setPrice(productToCart.getPrice());
			newItem.setProductDetail(productToCart);
			newItem.setProductDetailsID(productToCart.getId());
			curCart.add(newItem);
			session.setAttribute("curCart", curCart);
			return;
		}

		// Nếu trong cart có gì đó rồi, thì phải xét xem món đó đã từng nằm trong cart
		// chưa, nếu có thì chỉ tăng số lượng lên quantity thôi
		for (int i = 0; i < curCart.size(); i++) {
			if (productToCart.getId() == curCart.get(i).getProductDetailsID()) {// Nếu từng có rồi
				curCart.get(i).setQuantity(curCart.get(i).getQuantity() + quantity);
				session.setAttribute("curCart", curCart);
				return;
			}
		}

		// Nếu đây là 1 món hoàn toàn mới
		Cart newItem = new Cart();
		newItem.setQuantity(quantity);
		newItem.setPrice(productToCart.getPrice());
		newItem.setProductDetail(productToCart);
		newItem.setProductDetailsID(productToCart.getId());
		curCart.add(newItem);
		session.setAttribute("curCart", curCart);
	}

}
