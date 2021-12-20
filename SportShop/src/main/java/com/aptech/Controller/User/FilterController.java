package com.aptech.Controller.User;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.ProductDao;

@Controller
public class FilterController {

	private ProductDao productDao = new ProductDao();
	private CategoryDao categoryDao = new CategoryDao();

	@ResponseBody
	@RequestMapping(value = { "/ajax/addFilter" }, method = RequestMethod.POST)
	public ModelAndView addFilter(Model model, HttpServletRequest request) {
		ArrayList<String> filterList = new ArrayList<String>();
		ModelAndView mv = new ModelAndView("/user/productListHandling");
		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		CategoryDao categoryDao = new CategoryDao();
		if (type.equals("sport")) {
			filterList.add(categoryDao.getSportTypeByID(id).getName());
			mv.addObject("listProduct", productDao.getBySportType(id, id));
		} else {
			filterList.add(categoryDao.getProductTypeByID(id).getName());
			mv.addObject("listProduct", productDao.getByProductType(id));
		}
		mv.addObject("filterList", filterList);
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = { "/ajax/showFilterInput" }, method = RequestMethod.GET)
	public ModelAndView showFilterInput(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/user/filterInput");
		return mv;
	}
}
