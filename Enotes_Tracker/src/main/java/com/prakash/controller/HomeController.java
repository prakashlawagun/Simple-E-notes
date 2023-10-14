package com.prakash.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prakash.dao.UserDao;
import com.prakash.entity.User;

@Controller
public class HomeController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(path="/loginUser",method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session) {
		User user = userDao.login(email, password);
		if(user != null) {
			session.setAttribute("loginuser", user);
			return "redirect:/home";
		}else {
			session.setAttribute("msg", "Invalid Credentials.");
		return  "redirect:/login";
		}
	}
	
	@RequestMapping(path="/registerUser", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute User user,HttpSession session) {
		userDao.saveUser(user);
		session.setAttribute("msg","Register Sucessfully");
		return "redirect:/register"; 
	}
	
	
	/* @RequestMapping("/addNotes")
	public String addNotes() {
		return "add_notes";
	}
	
	@RequestMapping("/viewNotes")
	public String viewNotes() {
		return "view_notes";
	}
	
	@RequestMapping("/editNotes")
	public String editNotes() {
		return "edit_notes";
	} */
	

}
