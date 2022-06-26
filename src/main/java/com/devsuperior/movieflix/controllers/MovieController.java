package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@GetMapping
	public ResponseEntity<Page<MovieMinDTO>> findAll(
			@RequestParam(name="genreid", defaultValue = "0") Long genreid,
			Pageable pageable) {
		Page<MovieMinDTO> page = service.findAll(pageable);

		return ResponseEntity.ok().body(page);
	}
}
