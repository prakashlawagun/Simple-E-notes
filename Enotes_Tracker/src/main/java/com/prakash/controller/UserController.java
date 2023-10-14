package com.prakash.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prakash.dao.UserDao;
import com.prakash.entity.Notes;
import com.prakash.entity.User;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/addNotes")
	public String addNotes() {
		
		return "add_notes";
	}
	
	@RequestMapping(path="/saveNotes",method=RequestMethod.POST)
	public String saveNotes(@ModelAttribute Notes note,HttpSession session) {
		
		User user=(User)session.getAttribute("loginuser");
		note.setUser(user);
		note.setDate(LocalDateTime.now().toString());
		userDao.saveNotes(note);
		session.setAttribute("msg", "Notes Added Successfully");
		
		return "redirect:/user/viewNotes";
	}
	
	@RequestMapping("/viewNotes")
	public String viewNotes(HttpSession session,Model model) {
		User user=(User)session.getAttribute("loginuser");
		List<Notes> notes = userDao.getNotesByUser(user);
		model.addAttribute("list", notes);
		return "view_notes";
	}
	
	@RequestMapping("/deleteNotes")
	public String deleteNotes(@RequestParam("id") int id,HttpSession session) {
		userDao.deleteNotes(id);
		session.setAttribute("msg","Delete Successfully.");
		return "redirect:/user/viewNotes";
	}
	
	
	@RequestMapping("/editNotes")
	public String editNotes(@RequestParam("id") int id,Model model) {
		Notes note = userDao.getNotesById(id);
		model.addAttribute("notes",note);
		return "edit_notes";
	}
	
	@RequestMapping(path="/updateNotes",method=RequestMethod.POST)
	public String updateNotes(@ModelAttribute Notes note,HttpSession session) {
		User user = (User) session.getAttribute("loginuser");
		note.setUser(user);
		note.setDate(LocalDateTime.now().toString());
		userDao.updateNotes(note);			
		session.setAttribute("msg", "Update Successfully.");
		return "redirect:/user/viewNotes";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginuser");
		session.setAttribute("msg", "Logout Successfully");
		return "login";
	}
	
}
