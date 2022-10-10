package com.danielberkness.news.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.danielberkness.news.model.User;
import com.danielberkness.news.service.UserService;
import com.danielberkness.news.web.dto.UserRegistrationDto;

@Controller

public class UserUpdateController {

	@Autowired
	UserService userService;

	public UserUpdateController(UserService userService) {
		super();
		this.userService = userService;
	}

	/*
	 * @ModelAttribute("user") public UserRegistrationDto userRegistrationDto() {
	 * return new UserRegistrationDto(); }
	 */ 

	@GetMapping("/update")
	public String showFormForUpdate(Principal loggedInUser, ModelMap model) {
		System.out.println(loggedInUser.getName());
		User user = userService.findUserByUsername(loggedInUser.getName());
		model.put("user", user);
		return "update";

	}

	@PostMapping("/update")
	public String updateUser(@ModelAttribute User user) {
		
		userService.save(user);

		return "redirect:/update";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		this.userService.deleteUserById(id);
		return "redirect:/";

	}

}
