package com.aptech.Controller.User;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.ProductDao;
import com.aptech.Dao.StaffDao;
import com.aptech.Model.Customer;
import com.aptech.Model.Staff;

@Controller
public class HomeController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView showViewIndex(Model model, HttpServletRequest request) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/index");
		ProductDao productDao = new ProductDao();
		model.addAttribute("customer", new Customer());
		mv.addObject("index_listProduct", productDao.getIndexListProduct());
		mv.addObject("index_featuredProduct", productDao.getIndexFeaturedProduct());
		mv.addObject("index_newestProduct", productDao.getNewestProduct());
		CategoryDao categoryDao = new CategoryDao();
		mv.addObject("productTypeList", categoryDao.getAllProductType());
		mv.addObject("sportTypeList", categoryDao.getAllSportType());
		return mv;
	}

	@RequestMapping(value = { "/admin/" }, method = RequestMethod.GET)
	public ModelAndView AdminView(Model model, HttpServletRequest request) {
		model.getAttribute("staff");
		ModelAndView mv = new ModelAndView("admin/index");
		ProductDao productDao = new ProductDao();
		CategoryDao cateDao = new CategoryDao();
		model.addAttribute("customer", new Customer());

		mv.addObject("ProductTypeList", cateDao.getAllProductType());
		mv.addObject("SportTypeList", cateDao.getAllSportType());
		mv.addObject("listProduct", productDao.getAll());
		
		return mv;
	}
}
