package com.danielberkness.news.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielberkness.news.dto.NewsResponse;
import com.danielberkness.news.service.SerpService;

@RestController
public class SerpController {
	
	@Autowired
	private SerpService serpService;
	
	@GetMapping("/test")
	public ResponseEntity<NewsResponse> getNews() {
		return serpService.getNews();
		
		
	}
}
