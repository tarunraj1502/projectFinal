package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.MovieDto;
import com.capg.entity.Movie;
import com.capg.entity.Show;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.MovieAlreadyExistsException;
import com.capg.exception.MovieNotExistsException;
import com.capg.exception.NullValueException;
import com.capg.repository.MovieRepository;
import com.capg.repository.ShowRepository;
import com.capg.utility.AppConstant;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ShowRepository showRepository;
	@Override
	public Movie addMovie(Movie movie)
	{
		Optional<Movie> movieExist = movieRepository.findByMovieNameIgnoreCase(movie.getMovieName());
		if(movie.getMovieName().isEmpty())
		{
			throw new NullValueException(AppConstant.NULL_VALUE_INFO);
		}
		if (movieExist.isPresent()) {
	
			throw new MovieAlreadyExistsException(AppConstant.MOVIE_ALREADY_EXIST_INFO);
		}
		movie.setMovieName(movie.getMovieName().toLowerCase());
		movie.setGenre(movie.getGenre().toLowerCase());
		return movieRepository.save(movie);
	}

	public String deleteMovieById(int movieId)
	{
		String message;
		if (movieRepository.existsById(movieId)) 
		{
			movieRepository.deleteById(movieId);
			message = "movie successfully deleted";
		} else
		{
			throw new IdNotFoundException(AppConstant.MOVIE_ID_NOT_FOUND_INFO);
		}

		return message;
	}

	public List<MovieDto> getAllMovie() {
		List<Movie> movies= movieRepository.findAll();
		System.out.println("moviess-----------"+movies);
		List<MovieDto> movieDtos=new ArrayList<>();
		 for(Movie movie: movies)
		 {
			 Optional<Show> shows=showRepository.findById(movie.getMovieId());
			 System.out.println(shows);
			 if(shows.isEmpty())
				 break;
			 else {
				 Show show=shows.get();
				 MovieDto movieDto=new MovieDto();
				 movieDto.setMovieName(movie.getMovieName());
				 movieDto.setGenre(movie.getGenre());
				 movieDto.setSlotNo(show.getSlotNo());
				 movieDto.setFromDate(show.getFromDate());
				 movieDto.setToDate(show.getToDate());
				 movieDtos.add(movieDto);
				 System.out.println(movieDtos);
			 }
		 }
		return movieDtos;
	}


	public Movie getMovieById(int movieId) {
		Optional<Movie> movieById = movieRepository.findById(movieId);
		if(movieById.isEmpty())
		{
			throw new IdNotFoundException(AppConstant.MOVIE_ID_NOT_FOUND_INFO);
		}
		return movieById.get();
	}

	public Movie getMovieByName(String movieName) {
		String moviesName=movieName.toLowerCase();
		Optional<Movie> movieByName = movieRepository.findByMovieName(moviesName);
		if(movieByName.isEmpty())
		{
			throw new MovieNotExistsException(AppConstant.MOVIE_NOT_FOUND_INFO);
		}
		return movieByName.get();
	}
//   @Override
//   public List<MovieDto> getAllMovies(){
//	   return movieRepository.findAll();
//   }
	

}
