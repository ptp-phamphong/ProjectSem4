package com.aptech.Controller.User;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aptech.Dao.CategoryDao;
import com.aptech.Dao.ProductDao;
import com.aptech.Model.Cart;
import com.aptech.Model.ProductFilter;

@Controller
public class FilterController {

	private ProductDao productDao = new ProductDao();
	private CategoryDao categoryDao = new CategoryDao();

	@ResponseBody
	@RequestMapping(value = { "/ajax/addFilter" }, method = RequestMethod.POST)
	public ModelAndView addFilter(Model model, HttpServletRequest request) {
		String sql = "SELECT * FROM PRODUCT WHERE (";
		ArrayList<ProductFilter> productFilterList = new ArrayList<ProductFilter>();

		HttpSession session = request.getSession();
		productFilterList = (ArrayList<ProductFilter>) session.getAttribute("productFilterList");
		if (productFilterList == null) {
			productFilterList = new ArrayList<ProductFilter>();
		}
		
		ModelAndView mv = new ModelAndView("/user/productListHandling");

		ProductFilter productFilter = new ProductFilter();
		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));
		productFilter.setFilterItemType(type);
		productFilter.setFilterItemId(id);

		CategoryDao categoryDao = new CategoryDao();
		if (type.equals("SportTypeId")) {
			productFilter.setFilterItemName(categoryDao.getSportTypeByID(id).getName());
		} else {
			productFilter.setFilterItemName(categoryDao.getProductTypeByID(id).getName());
		}

		productFilterList.add(productFilter);
		session.setAttribute("productFilterList", productFilterList);
		boolean check = false;

		if (productFilterList.get(0).getFilterItemType().equals("ProductTypeId")) {
			for (ProductFilter item : productFilterList) {
				if (item.getFilterItemType().equals("ProductTypeId")) {
					sql += (item.getFilterItemType() + "=" + item.getFilterItemId() + " OR ");
				} else {
					check = true;
				}
			}
			
			sql = sql.substring(0, sql.length()-4);
			
			if (check) {
				sql += ") AND (";
			} else {
				sql += ")";
			}

			for (ProductFilter item : productFilterList) {
				if (item.getFilterItemType().equals("SportTypeId")) {
					sql += (item.getFilterItemType() + "=" + item.getFilterItemId() + " OR ");
				}
			}
		} else {
			for (ProductFilter item : productFilterList) {
				if (item.getFilterItemType().equals("SportTypeId")) {
					sql += (item.getFilterItemType() + "=" + item.getFilterItemId() + " OR ");
				} else {
					check = true;
				}
			}
			sql = sql.substring(0, sql.length()-4);
			if (check) {
				sql += ") AND (";
			} else {
				sql += ")";
			}
			for (ProductFilter item : productFilterList) {
				if (item.getFilterItemType().equals("ProductTypeId")) {
					sql += (item.getFilterItemType() + "=" + item.getFilterItemId() + " OR ");
				}
			}
			if (check) {
				sql = sql.substring(0, sql.length()-4);
				sql +=")";
			}		
		}
		mv.addObject("listProduct", productDao.getProductbySQL(sql));
		return mv;
	}

	@ResponseBody
	@RequestMapping(value = { "/ajax/showFilterInput" }, method = RequestMethod.GET)
	public ModelAndView showFilterInput(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/user/filterInput");
		return mv;
	}
}
