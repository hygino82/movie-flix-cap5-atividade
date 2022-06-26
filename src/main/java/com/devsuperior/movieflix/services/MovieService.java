package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	public Page<MovieMinDTO> findAll(Pageable pageable) {
		Page<Movie> page = repository.findAll(pageable);
		Page<MovieMinDTO> result = page.map(x -> new MovieMinDTO(x));

		return result;
	}

}
