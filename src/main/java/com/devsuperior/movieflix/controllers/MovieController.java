package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/{id}")
	public ResponseEntity<MovieDetailsDTO> findById(@PathVariable("id") Long id) {
		MovieDetailsDTO obj = service.findById(id);
		
		return ResponseEntity.ok(obj);
	}

	@GetMapping
	public ResponseEntity<Page<MovieCardDTO>> findAll(
			@RequestParam(name = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable) {
		Page<MovieCardDTO> page = service.findAll(genreId, pageable);

		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/{movieId}/reviews")
	public ResponseEntity<List<ReviewDTO>> findByMovieReviews(@PathVariable Long movieId) {

		List<ReviewDTO> list = reviewService.findByMovie(movieId);
		return ResponseEntity.ok(list);
	}
}
