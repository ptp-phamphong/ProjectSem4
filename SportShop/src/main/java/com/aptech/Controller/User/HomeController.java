package com.aptech.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.ProductDao;
import com.aptech.Model.Customer;

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
}
