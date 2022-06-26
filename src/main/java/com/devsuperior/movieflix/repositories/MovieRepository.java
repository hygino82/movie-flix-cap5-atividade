package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	 @Query("select DISTINCT obj from Movie obj " +
	            "INNER JOIN obj.genre gen "+
	            "Where COALESCE(:genre) IS NULL OR gen IN  :genre " +
	            "ORDER BY obj.title ASC")
	Page<Movie> findAllGenre(Genre genre, Pageable pageable);
	
//	@Query("SELECT obj FROM Movie obj JOIN FETCH obj.genre_id WHERE obj IN :genre")
//	List<Movie> findProductsWithCategories(List<Genre> genres);
//	
//	@Query("SELECT DISTINCT obj FROM Product obj INNER JOIN obj.categories cats WHERE "
//			+ "(COALESCE(:categories) IS NULL OR cats IN :categories) AND "
//			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%')) )" )
//	Page<Movie> find(List<Genre> genres, String name, Pageable pageable);
}
