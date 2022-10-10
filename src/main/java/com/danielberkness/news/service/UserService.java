package com.danielberkness.news.service;




import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.danielberkness.news.model.User;
import com.danielberkness.news.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	List<User> getAllUsers();
	
	
	User getUserById(Long id);
	
	void deleteUserById(Long id);

	User save(UserRegistrationDto userRegistrationDto);
	User save(User user);
	
	
	User findUserByUsername(String userName);


	User updateUserInfo(User user);

	
}
	
