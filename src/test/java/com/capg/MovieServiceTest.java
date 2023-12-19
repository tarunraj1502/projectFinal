package com.capg;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dto.MovieDto;
import com.capg.entity.Movie;
import com.capg.entity.Show;
import com.capg.repository.MovieRepository;
import com.capg.repository.ShowRepository;
import com.capg.service.MovieServiceImpl;
 
@SpringBootTest
public class MovieServiceTest {
	
	@Mock
	MovieRepository moviesRepository;
	@InjectMocks
	MovieServiceImpl moviesServiceImpl;
	

	@Test
	public void addMovieTest()
	{
		Movie movies = new Movie(1,"pathan","action");
		when(moviesRepository.save(movies)).thenReturn(movies);
		assertEquals(movies, moviesServiceImpl.addMovie(movies));
	}
   // public void deleteMovieTest
}
