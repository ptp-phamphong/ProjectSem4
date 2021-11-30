package com.aptech.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.ProductDao;

@Controller
public class HomeController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index() {
		return ("user/index");
	}

	

	@RequestMapping(value = { "/category" }, method = RequestMethod.GET)
	public ModelAndView product() {
		ProductDao productDao = new ProductDao();
		int a = productDao.getAll().size();

		ModelAndView mv = new ModelAndView("user/category");
		mv.addObject("list", productDao.getAll());

		return mv;
	}
}
