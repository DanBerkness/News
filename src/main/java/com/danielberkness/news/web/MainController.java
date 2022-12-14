package com.danielberkness.news.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.danielberkness.news.dto.NewsResponse;
import com.danielberkness.news.dto.Result;
import com.danielberkness.news.model.User;
import com.danielberkness.news.service.SerpService;
import com.danielberkness.news.service.UserService;

@Controller
public class MainController {
	@Autowired
	SerpService serpService;
	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/location")
	public String location() {
		return "location";
	}

	
	@GetMapping("/articles")
	public String getArticles(ModelMap model) {
		
		
		String location = "minneapolis,minnesota";
		
		List<Result> allArticles = serpService.getNews(location).getBody().getNewsResults().stream()
				.collect(Collectors.toList());
		
		model.addAttribute("allArticles",allArticles);
		
		return "articles";
	}
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
	
}
