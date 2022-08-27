package com.danielberkness.news.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class NewsResponse {
	public List<Result> getNewsResults() {
		return newsResults;
	}

	public void setNewsResults(List<Result> newsResults) {
		this.newsResults = newsResults;
	}

	@JsonProperty("news_results")
	List<Result> newsResults = new ArrayList<>();
}
