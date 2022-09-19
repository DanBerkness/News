package com.danielberkness.news.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@PostMapping
	public String updateUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
		String userName = ((UserDetails) SecurityContextHolder.getContext()
																  .getAuthentication()
																  .getPrincipal())
																  .getUsername();
		UserDetailsBuilder udb = new UserDetailsBuilder();
		UserDetailsBuilder u = User.withUsername(userName)
                .password("12345")
                .authorities("read", "write")
                .accountExpired(false)
                .disabled(true)
                .build();							  
															

		
//		User currentUser = (User) userService.loadUserByUsername(userName);
//		currentUser.setEmail(userRegistrationDto.getEmail());
//		currentUser.setFirstName(userRegistrationDto.getFirstName());
//		currentUser.setLastName(userRegistrationDto.getLastName());
//		currentUser.setPassword(userRegistrationDto.getPassword());
		
		return "redirect:/update?success";
	}

}
