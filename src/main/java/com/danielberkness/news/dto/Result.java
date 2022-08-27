package com.danielberkness.news.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class Result {
	@JsonProperty("position")
	public int position;
	@JsonProperty("link")
	public String link;
	@JsonProperty("title")
	public String title;
	@JsonProperty("source")
	public String source;
	@JsonProperty("date")
	public String date;
	@Override
	public String toString() {
		return "Result [position=" + position + ", link=" + link + ", title=" + title + ", source=" + source + ", date="
				+ date + ", snippet=" + snippet + ", thumbNail=" + thumbNail + "]";
	}
	@JsonProperty("snippet")
	public String snippet;
	@JsonProperty("thumbnail")
	public String thumbNail;
	
	
	
	
	
	
//	"position": 1,
//    "link": "https://www.washingtonpost.com/opinions/2022/08/21/maggie-hassan-bipartisan-midterm-message/",
//    "title": "Opinion | Purple politics could keep the Senate blue",
//    "source": "The Washington Post",
//    "date": "5 hours ago",
//    "snippet": "NASHUA, N.H. — Sen. Maggie Hassan is one of the leading champions of \npolitics colored not in red and blue but in lilac or violet.",
//    "thumbnail": "https://serpapi.com/searches/630288e92c6878ca02fba0d2/images/3b35099d1481c2bcce21737e323f66fd496224347777137da33d67b17a5d8d1e.jpeg"
}
