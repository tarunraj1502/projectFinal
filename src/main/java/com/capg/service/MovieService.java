package com.capg.service;

import java.util.List;

import com.capg.dto.MovieDto;
import com.capg.entity.Movie;

public interface MovieService {

	Movie addMovie(Movie movie);
	String deleteMovieById(int movieId);
	List<MovieDto> getAllMovie();
	Movie getMovieByName(String movieName);
	Movie getMovieById(int movieId);
	//List<MovieDto> getAllMovies();
}
