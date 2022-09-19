package com.danielberkness.news.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.danielberkness.news.model.User;
import com.danielberkness.news.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	

	User save(UserRegistrationDto userRegistrationDto);
	
	User getUser(User user);
	
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
}
	
