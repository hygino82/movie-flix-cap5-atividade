package com.devsuperior.movieflix.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.movieflix.entities.Review;

public class MovieDTO {
	
	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	private List<Review> reviews = new ArrayList<>();
	
	public MovieDTO() {
	}
}
