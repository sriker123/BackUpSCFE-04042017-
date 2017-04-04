package com.niit.slt1.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {
	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public ModelAndView showRegisterPage() {
		System.out.println("showRegisterPage called****");
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", "true");
		mv.addObject("userObject", user);

		return mv;
	}

	// Step#2 to Register a user
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createCategory(@ModelAttribute(value = "userObject") User user) {

		userDAO.save(user);

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("smsg", "Registration Succesfull");

		return mv;

	}

	// Login page

	@RequestMapping(value = "/login", method = RequestMethod.GET) // this should
																	// have the
																	// same name
																	// as the
																	// jsp file
	public ModelAndView showLoginPage() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", "true");

		return mv;
	}

	@RequestMapping("/validate")
	// @PostMapping("/"validate")
	public ModelAndView validateCredentials(@RequestParam("userName") String name,
			@RequestParam("password") String pwd) {
		// Actually we have to get data from DataBase
		// Temporarily UserID-Spike Password -Qwerty@123
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("msg", "welcome to shopping cart");

		if (userDAO.validate(name, pwd) == true) {
			mv.addObject("isUserLoggedIn", "true");

			user = userDAO.getUserbyName(name);
			if (user.getRole().equals("Admin")) {
				mv.addObject("isAdmin", "true");
			} else {
				mv.addObject("isAdmin", "false");
			}
			// mv.addObject("successmsg","Valid Credentials");
			session.setAttribute("loginmessage", "Welcome:  " + name);
		} else {
			mv.addObject("errormsg", "Invalid Credentials....please try again");
		}
		return mv;
	}

}
