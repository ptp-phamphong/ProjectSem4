package com.aptech.Controller.User;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.ImageDao;
import com.aptech.Dao.ProductDao;
import com.aptech.Dao.ProductDetailDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;
import com.aptech.Model.Product;
import com.aptech.Model.Staff;
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

	@RequestMapping(value = { "/admin/" }, method = RequestMethod.GET)
	public ModelAndView showAdminProductList(Model model) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		model.addAttribute("staff", new Staff());
		ModelAndView mv = new ModelAndView("admin/index");

		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());
		mv.addObject("listProduct", productDao.getAllProduct());

		return mv;
	}

	@ResponseBody
	@RequestMapping(value = { "/ChangeImageProduct" }, method = RequestMethod.GET)
	public String ChangeImageProduct(@RequestParam String imgItem) {
		
		String html="";
		String url = "/SportShop/assets/user/images/products/"+imgItem+".jpg";
		
		html += "<img src='"+url+"' alt=\"product\" />";
		return html;
	}

	@RequestMapping(value = { "/admin/product/sport/{sport}" }, method = RequestMethod.GET)
	public ModelAndView showAdminProductListBySport(Model model, @PathVariable("sport") int sport) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		model.addAttribute("staff", new Staff());
		ModelAndView mv = new ModelAndView("admin/product");

		if (sport == 0) {
			mv.addObject("ProductTypeList", cateDao.getAllProductType());
			mv.addObject("SportTypeList", cateDao.getAllSportType());
			mv.addObject("listProduct", productDao.getAllProduct());
		} else {
			mv.addObject("SportName", cateDao.getSportTypeByID(sport).getName());
			mv.addObject("ProductTypeList", cateDao.getAllProductType());
			mv.addObject("SportTypeList", cateDao.getAllSportType());
			mv.addObject("listProduct", productDao.getBySport(sport));
		}

		return mv;
	}

	@RequestMapping(value = { "/admin/product/type/{productType}" }, method = RequestMethod.GET)
	public ModelAndView showAdminProductListByType(Model model, @PathVariable("productType") int productType) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		model.addAttribute("staff", new Staff());
		ModelAndView mv = new ModelAndView("admin/product");

		if (productType == 0) {
			mv.addObject("ProductTypeList", cateDao.getAllProductType());
			mv.addObject("SportTypeList", cateDao.getAllSportType());
			mv.addObject("listProduct", productDao.getAllProduct());
		} else {
			mv.addObject("ProductTypeName", cateDao.getProductTypeByID(productType).getName());
			mv.addObject("ProductTypeList", cateDao.getAllProductType());
			mv.addObject("SportTypeList", cateDao.getAllSportType());
			mv.addObject("listProduct", productDao.getByType(productType));
		}

		return mv;
	}

	@RequestMapping(value = { "/admin/productDetail/{id}" }, method = RequestMethod.GET)
	public ModelAndView showAdminProductDetail(Model model, @PathVariable("id") int id) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		ImageDao imgDao = new ImageDao();
		ProductDetailDao productDetailDao = new ProductDetailDao();
		model.addAttribute("staff", new Staff());
		ModelAndView mv = new ModelAndView("admin/productDetail");
		
		mv.addObject("ProductDetail", productDetailDao.getByIdProduct(id));
		mv.addObject("Product", productDao.getByProductID(id));
		mv.addObject("MainImage", imgDao.getByIdProduct(id).get(0));
		mv.addObject("Images", imgDao.getByIdProduct(id));
		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());

		return mv;
	}
	
	@RequestMapping(value = { "/admin/editproduct/{id}" }, method = RequestMethod.GET)
	public ModelAndView editProduct(Model model, @PathVariable("id") int id) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		ImageDao imgDao = new ImageDao();
		model.addAttribute("staff", new Staff());
		ModelAndView mv = new ModelAndView("admin/editproduct");

		mv.addObject("Product", productDao.getByProductID(id));
		mv.addObject("MainImage", imgDao.getByIdProduct(id).get(0));
		mv.addObject("Images", imgDao.getByIdProduct(id));
		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());

		return mv;
	}

	@RequestMapping(value = { "/{productType}/{sportType}/{productID:\\d+}",
			"/{productType}/{sportType}/{productID:\\d+}/**" }, method = RequestMethod.GET)
	// \d:+ chỉ nhận giá trị int
	public ModelAndView showProductDetails(Model model, @PathVariable("productID") int productID) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/product");
		mv.addObject("productDetails", productDao.getByProductID(productID));
		mv.addObject("nextProduct", productDao.getByProductID(productID + 1));
		if (productID == 1) {
			mv.addObject("prevProduct", productDao.getLastProduct());
		} else {
			mv.addObject("prevProduct", productDao.getByProductID(productID - 1));
		}
		return mv;
	}

	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
	public ModelAndView showCart(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/cart");
		ArrayList<Cart> cartList = new ArrayList();// TEST sau thay bang session
		cartList.add(new Cart(1, 2, 10));
		cartList.add(new Cart(2, 1, 15));
		mv.addObject("cartList", cartList);
		return mv;
	}

	// Các hàm xử lý giỏ hàng
	@ResponseBody
	@RequestMapping(value = { "/addToCart" }, method = RequestMethod.POST)
	public String sendEmail(HttpServletRequest request) {
		int idProduct = Integer.parseInt(request.getParameter("idProduct"));

		HttpSession session = request.getSession();
		ArrayList<Cart> curCart = new ArrayList<Cart>();
		curCart = (ArrayList<Cart>) session.getAttribute("cart");

		if (curCart == null) {// Nếu trong cart chưa có gì
			curCart = new ArrayList<Cart>();

			Cart newItem = new Cart();
			ProductDao productDao = new ProductDao();
			ProductDetailDao productDetailDao = new ProductDetailDao();
			Product productToCart = new Product();
			productToCart = productDao.getByProductID(Integer.parseInt(request.getParameter("idProduct")));
			// newItem.set
			newItem.setQuantity(1);
			newItem.setPrice(productDetailDao.getByIdProduct(idProduct).get(0).getPrice());
			newItem.setProductDetail(productDetailDao.getByIdProduct(idProduct).get(0));
			curCart.add(newItem);
			session.setAttribute("curCart", curCart);
		}

		return "done";
	}

	// Hết hàm rồi đấy, đmẹ đáng lẽ nên xài cái service

}
