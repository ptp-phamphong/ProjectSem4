package com.aptech.Controller.User;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.aptech.Dao.CustomerDao;
import com.aptech.Model.Cart;
import com.aptech.Model.Customer;
import com.aptech.MyClass.HashPassword;

@Controller
public class CustomerController {

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public ModelAndView showViewRegister(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/register");
		return mv;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView showViewLogin(Model model) {
		model.addAttribute("customer", new Customer());
		ModelAndView mv = new ModelAndView("user/login");
		return mv;
	}
	
	@RequestMapping(value= {"/loginHandelling"}, method = RequestMethod.POST)
	public RedirectView loginHandelling(@ModelAttribute("customer") Customer item, RedirectAttributes redir) {
		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer();
		
		//Chuyển qua MD5
		HashPassword HashPassword = new HashPassword();
		String passMD5 = HashPassword.getPassInMD5(item.getPassword());
		
		customer = customerDao.getAccountLogin(item.getEmail(), passMD5);
		
		if(customer == null) {
			RedirectView redirectView = new RedirectView("/login", true); //Muốn redirect đi đâu thì truyền vào đây
			//Dùng redirect view để tránh tên controller hiện trên thanh URL 
			//Lý do làm kiểu cũ index bị lỗi:
				//Để ý trên thanh URL sễ có SportShop/loginHandelling . Đây là địa chỉ hiển thị vị trí của CONTROLLER.
				//vì vị trí của controller nó nằm khác chỗ của views, nên CSS bị link sai hết
				//với lại mình có 2 layout, trong decorator set / với /* . 
				//  SportShop/loginHandelling -> /* 
				//  SportShop/ -> /
			
			redir.addFlashAttribute("customer", new Customer());//redirect ko truyền object theo kiểu kia, phải dùng kiểu này
			//Tương lai dùng session nên ko cần truyền theo kiểu này. Nhưng các nghiệp vụ khác phải theo kiểu này
			
			redir.addFlashAttribute("Error","Wrong username or password, please try again");
//			mv.setViewName("user/login");
			return redirectView;
		}
		RedirectView redirectView = new RedirectView("/cart", true);//Nếu muốn truyền về index thì chỉ ghi "/". Thử test đi là biết nguyên lý
//		mv.setViewName("user/category");
		redir.addFlashAttribute("currentCustomer", customer);
		
		ArrayList<Cart> cartList = new ArrayList();//TEST sau thay bang session
		cartList.add(new Cart(1, 2, 10));
		cartList.add(new Cart(2, 1, 15));
		redir.addFlashAttribute("cartList", cartList);

		return redirectView;
	}

	@RequestMapping(value = { "/cart" }, method = RequestMethod.GET)
	public ModelAndView showCart(Model model) {
		model.addAttribute("currentCustomer", new Customer());
		ModelAndView mv = new ModelAndView("user/cart");
		
		ArrayList<Cart> cartList = new ArrayList();//TEST sau thay bang session
		cartList.add(new Cart(1, 2, 10));
		cartList.add(new Cart(2, 1, 15));
		mv.addObject("cartList", cartList);
		return mv;
	}
}
