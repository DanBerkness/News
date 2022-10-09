package com.danielberkness.news.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danielberkness.news.model.User;
import com.danielberkness.news.service.UserService;
import com.danielberkness.news.web.dto.UserRegistrationDto;
@Controller
@RequestMapping("/update")

public class UserUpdateController {
	
	@Autowired
	UserService userService;
	
	public UserUpdateController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showUpdateForm() {
		return "update";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		User user = userService.getUserById(id);
		System.out.println(user.getFirstName());
		model.addAttribute("user", user);
		return "/";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		this.userService.deleteUserById(id);
		return "redirect:/";
		
	}

}
