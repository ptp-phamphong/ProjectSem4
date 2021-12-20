package com.aptech.Controller.User;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.ImageDao;
import com.aptech.Dao.ProductDao;
import com.aptech.Dao.ProductDetailDao;
import com.aptech.Dao.SizeDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;
import com.aptech.Model.Product;
import com.aptech.Model.Staff;
import com.aptech.Model.ProductDetail;
import com.aptech.Model.Size;
import com.aptech.MyClass.SendingEmail;

@Controller
public class ProductController {

	@RequestMapping(value = { "/all-product" }, method = RequestMethod.GET)
	public ModelAndView showProductList(Model model) {
		ProductDao productDao = new ProductDao();
		CategoryDao categoryDao = new CategoryDao();
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/productList");

		mv.addObject("listProduct", productDao.getAll());
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
		return mv;
	}

	@RequestMapping(value = {"/{productType}-{productTypeId:\\d+}/{sportType}-{sportTypeId:\\d+}" }, method = RequestMethod.GET)
	public ModelAndView showProductbySportType(Model model, @PathVariable(value = "productTypeId") Integer productTypeID,
			@PathVariable(value = "sportTypeId") Integer sportTypeID) {
		ProductDao productDao = new ProductDao();
		CategoryDao categoryDao = new CategoryDao();
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/productList");
		mv.addObject("listProduct", productDao.getBySportType(productTypeID, sportTypeID));
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
		return mv;
	}
	
	@RequestMapping(value = {"/{productType}-{productTypeId:\\d+}" }, method = RequestMethod.GET)
	public ModelAndView showProductbyType(Model model, @PathVariable(value = "productTypeId") Integer productTypeID) {
		
		ProductDao productDao = new ProductDao();
		CategoryDao categoryDao = new CategoryDao();
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/productList");
		mv.addObject("listProduct", productDao.getByType(productTypeID));
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
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

		String html = "";
		String url = "/SportShop/assets/user/images/products/" + imgItem + ".jpg";

		html += "<img src='" + url + "' alt=\"product\" />";
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
	
	@RequestMapping(value = { "/admin/addProduct" }, method = RequestMethod.GET)
	public ModelAndView addProduct(Model model) {
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		ImageDao imgDao = new ImageDao();
		model.addAttribute("staff", new Staff());
		ModelAndView mv = new ModelAndView("admin/addProduct");

		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());

		return mv;
	}
	
	@PostMapping("addNewProduct")
	public void addProduct(@RequestParam String name, int productType, int sportType, String details, int discount, String image1, String image2, String image3) {
		ProductDao proDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		Product pro = new Product();
		
		pro.setName(name);
		pro.setProductType(cateDao.getProductTypeByID(productType));
		pro.setSportType(cateDao.getSportTypeByID(sportType));
		pro.setDetails(details);
		pro.setDiscount(discount);
		proDao.add(pro);
	}

	@RequestMapping(value = { "/{productType}/{sportType}/{productID:\\d+}",
			"/{productType}/{sportType}/{productID:\\d+}/**" }, method = RequestMethod.GET)
	// \d:+ chỉ nhận giá trị int
	public ModelAndView showProductDetails(Model model, HttpServletRequest request,
			@PathVariable("productID") int productID) {
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/product");
		mv.addObject("productDetails", productDao.getByProductID(productID));

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
		CategoryDao categoryDao = new CategoryDao();
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
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

	@ResponseBody
	@RequestMapping(value = { "/ajax/showProductList" }, method = RequestMethod.GET)
	public ModelAndView showProductList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/user/productList");
		return mv;
	}
}
