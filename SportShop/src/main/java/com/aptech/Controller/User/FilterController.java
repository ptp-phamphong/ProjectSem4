package com.aptech.Controller.User;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.ProductDao;

public class FilterController {
	
	private ProductDao productDao = new ProductDao();
	private CategoryDao categoryDao = new CategoryDao();
	
	@RequestMapping(value = { "/ajax/addFilter" }, method = RequestMethod.GET)
	public ModelAndView addFilter(HttpServletRequest request) {
		ArrayList<String> filterList = new ArrayList<String>();

		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		
		if (type.equals("sport")) {
			filterList.add("a");
		}else {
			filterList.add(categoryDao.getProductTypeByID(id).getName());
			
		}
		ModelAndView mv = new ModelAndView("/user/filterInput");
		mv.addObject("filterList", filterList);
		return mv;
	}
}
