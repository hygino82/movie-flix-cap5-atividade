package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private AuthService authService;

	public ReviewDTO insert(ReviewDTO dto) {

		User user = authService.authenticated();
		Movie movie = movieRepository.getOne(dto.getMovieId());

		Review entity = new Review(dto.getText().strip(), user, movie);

		entity = repository.save(entity);

		return new ReviewDTO(entity);

	}

	public List<ReviewDTO> findByMovie(Long movieId) {
		Movie movie = movieRepository.getOne(movieId);
		List<Review> list = repository.findAllByMovie(movie);
		return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
	}
}
