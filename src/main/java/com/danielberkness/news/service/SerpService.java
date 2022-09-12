package com.danielberkness.news.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.danielberkness.news.dto.NewsResponse;
import com.danielberkness.news.dto.Result;



@Service
public class SerpService {

	public ResponseEntity<NewsResponse> getNews() {
		
		String location = "Minneapolis,Minnesota";
//		use location in Q search.
		String searchQuery = "cat";
		
		RestTemplate rt = new RestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl("https://serpapi.com/search")
				.queryParam("api_key", "13d0fb3be9baf1866d4d00e4f6f8abdd028754189919044959a1a2cc556eabd2")
				.queryParam("q", searchQuery)
				.queryParam("location", location)
				.queryParam("tbm", "nws")
				.build()
				.toUri();
		
		ResponseEntity<NewsResponse> news = rt.getForEntity(uri, NewsResponse.class);
		

		
		
//		List<Result> results = news.getBody().getNewsResults();
//		results.forEach(r -> System.out.println(r.toString()));
		
		return news;
	}
}
