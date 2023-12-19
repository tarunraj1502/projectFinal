package com.capg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {


	Optional<Movie> findByMovieNameIgnoreCase(String movieName);

	Optional<Movie> findByMovieName(String movieName);


	
}
