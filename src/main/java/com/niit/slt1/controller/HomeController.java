package com.niit.slt1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class HomeController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private User user;

	/*
	  CategoryDAO categoryDAO;
	  
	  @Autowired SupplierDAO supplierDAO;
	  
	  @Autowired ProductDAO productDAO;
	  
	  @Autowired Product product;
	  
	  @Autowired Supplier supplier;
	  
	  @Autowired Category category;
	 */

	@Autowired
	private HttpSession session;// the session is autowired we can use the
								// session.

	@RequestMapping(value = "/") // MethodHandler
	public ModelAndView showHomePage() {
		System.out.println("this is at home page method");
		ModelAndView mv = new ModelAndView("/home");// Specifying which page we
													// have to navigate
		mv.addObject("msg", "Welcome to Shopping Cart");// What data we have to
														// carry home page
		return mv;
		/*
		 * ModelAndView mv=new ModelAndView("/home"); List<Category>
		 * categoryList = categoryDAO.getCallCategory(); List<Product>
		 * productList = productDAO.getcallProducts(); List<Supplier>
		 * supplierList = supplierDAO.list();
		 * 
		 * 
		 * session.setAttribute("categoryList",categoryList);
		 * session.setAttribute("productList",productList);
		 * session.setAttribute("supplierList",supplierList);
		 * 
		 * session.setAttribute("category", category);
		 * session.setAttribute("product", product);
		 * session.setAttribute("supplier", supplier); return mv;
		 */
	}

	/**
	 * if(id.equals("Spike")&& pwd.equals("Qwerty@123")) {
	 * 
	 * mv.addObject("successmsg","Valid Credentials");
	 * session.setAttribute("loginmessage","Welcome:  "+id); } else {
	 * System.out.println("Wrong Credentials"); mv.addObject("errormsg",
	 * "Invalid Credentials....please try again"); } return mv; }
	 */

	@RequestMapping("/laptop")
	public ModelAndView laptop() {
		System.out.println("this is at laptop page");
		ModelAndView mv = new ModelAndView("/laptop");// Specifying which page
														// we have to navigate
		return mv;
	}

	@RequestMapping("/mobile")
	public ModelAndView mobile() {
		System.out.println("this is at mobile page");
		ModelAndView mv = new ModelAndView("/mobile");// Specifying which page
														// we have to navigate
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("/home");

		session.removeAttribute("loginmessage");// what ever the values attached
												// to the session are removed

		return mv;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
