package com.devsuperior.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
//	@Query("SELECT obj FROM Movie obj JOIN FETCH obj.genre_id WHERE obj IN :genre")
//	List<Movie> findProductsWithCategories(List<Genre> genres);
//	
//	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE "
//			+ "(COALESCE(:categories) IS NULL OR cats IN :categories) AND "
//			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%')) )" )
//	Page<Movie> find(List<Genre> genres, String name, Pageable pageable);
}
