package com.aptech.Controller.User;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.InvoiceDao;
import com.aptech.Dao.InvoiceDetailDao;
import com.aptech.Dao.ProductDetailDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;
import com.aptech.Model.Invoice;
import com.aptech.Model.InvoiceDetail;
import com.aptech.Model.ProductDetail;

@Controller
public class CartController {

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

		//Hàm xử lý check out
		@RequestMapping(value = { "/checkOutHandelling" }, method = RequestMethod.GET)
		public ModelAndView checkOutHandelling(Model model, HttpServletRequest request) {
			model.addAttribute("customer", new Customer());
			HttpSession session = request.getSession();
			//Lấy khách hiện tại ra
			Customer currentCustomer = new Customer();
			currentCustomer = (Customer) session.getAttribute("currentCustomer");
			
			//Lấy giỏ hàng ra
			ArrayList<Cart> curCart = new ArrayList<Cart>();
			curCart = (ArrayList<Cart>) session.getAttribute("curCart");
			//Xử lý thêm vào db
			//Đầu tiên tạo 1 cái invoice
			Invoice invoice = new Invoice();
			invoice.setCustomer(currentCustomer);
//			invoice.setStaff(null);
			invoice.setCreateDate(new Date(0));
			
			//Tính tổng tiền trong giỏ hàng
			int totalPrice =0 ;
			for (Cart cart : curCart) {
				totalPrice = cart.getPrice()*cart.getQuantity() + totalPrice;
			}
			invoice.setTotalPrice(totalPrice);
			
			InvoiceDao invoiceDao = new InvoiceDao();
			invoiceDao.addNew(invoice);
			
			//Rồi lấy cái cuối ra để có id
			invoice = invoiceDao.getLast();
			
			

			//Sau đó thêm vào các invoice Details
			for (Cart cart : curCart) {
				InvoiceDetail invoiceDetail = new InvoiceDetail();
				InvoiceDetailDao invoiceDetailDao = new InvoiceDetailDao();
				invoiceDetail.setInvoice(invoice);
				invoiceDetail.setProductDetail(cart.getProductDetail());
				invoiceDetail.setQuantity(cart.getQuantity());
				invoiceDetail.setUnit(cart.getPrice());
				invoiceDetailDao.addNew(invoiceDetail);
			}
			//Xóa session Cart đi
			session.removeAttribute("curCart");
			
			
			ModelAndView mv = new ModelAndView("/user/ShoppingHistory");
			return mv;
		}
		
		//Hàm đưa người dùng ra lịch sử mua hàng
		@RequestMapping(value = { "/ShoppingHistory" }, method = RequestMethod.GET)
		public ModelAndView ShoppingHistory(Model model, HttpServletRequest request) {
			
			
			ModelAndView mv = new ModelAndView("/user/ShoppingHistory");
			return mv;
		}
		
		
		
		
		
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