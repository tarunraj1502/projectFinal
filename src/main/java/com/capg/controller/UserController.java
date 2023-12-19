package com.capg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.AdminDto;
import com.capg.dto.BookingDto;
import com.capg.dto.MovieDto;
import com.capg.dto.UserDto;
import com.capg.entity.Booking;
import com.capg.entity.Movie;
import com.capg.entity.Show;
import com.capg.entity.ShowAvailability;
import com.capg.entity.User1;
import com.capg.exception.IdNotFoundException;
import com.capg.service.AvailabilityServiceImpl;
import com.capg.service.BookingServiceimpl;
import com.capg.service.MovieService;
import com.capg.service.ShowService;
import com.capg.service.UserService;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private AvailabilityServiceImpl availService;
	
	@Autowired
	private BookingServiceimpl bookingService;

	@PostMapping("/register")
	public ResponseEntity<User1> registration(@RequestBody User1 user) {
		System.out.println(user);
		return new ResponseEntity<User1>(userService.registration(user), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login1(@RequestBody User1 user) {
		return new ResponseEntity<String>(userService.login(user), HttpStatus.OK);
	}

	@PostMapping("/forgotPassword")
	public ResponseEntity<String> forgotPassword(@RequestBody UserDto userDto) {
		return new ResponseEntity<String>(userService.forgotUserPassword(userDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable int userId) {
		return new ResponseEntity<String>(userService.deleteUser(userId), HttpStatus.OK);
	}

	@GetMapping("/getAllMovie")
	public ResponseEntity<List<MovieDto>> getAllMovie() {
		return new ResponseEntity<List<MovieDto>>(movieService.getAllMovie(), HttpStatus.OK);
	}
	
	@GetMapping("/movie/{movieName}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName) {
		return new ResponseEntity<Movie>(movieService.getMovieByName(movieName), HttpStatus.OK);
	}
	@GetMapping("/getMovie/{movieId}")
    public ResponseEntity<Movie> getMovieById (@PathVariable int movieId)
    {
    	return new ResponseEntity<Movie> (movieService.getMovieById(movieId),HttpStatus.OK);
    }
	
	@GetMapping("/getShow/{showId}")
    public ResponseEntity<Show> getShowById (@PathVariable int showId)
    {
    	return new ResponseEntity<Show> (showService.getShowById(showId),HttpStatus.OK);
    }
	
	@GetMapping("/betweenDates")
    public ResponseEntity<List<Show>> getShowsBetweenDates (
    		@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate fromDate,
    		@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate toDate)
    {
    	return new ResponseEntity<List<Show>> (showService.getShowBetweenDates(fromDate,toDate),HttpStatus.OK);
    }
	


	 @PostMapping("/booking")
	  public ResponseEntity<Booking> addNewBooking(@RequestBody BookingDto bookingDto){
		  return new ResponseEntity<Booking>(bookingService.createNewBooking(bookingDto),HttpStatus.OK);
	}
	 
	@GetMapping("/cancelBooking/new/{bookingId}")
	public ResponseEntity<String> cancelBookingNewById(@PathVariable("bookingId") int bookingId) {
		return new ResponseEntity<String>(bookingService.cancelBookingNew(bookingId), HttpStatus.OK);
	}
	
	@GetMapping("/userdashboard/{userId}")
	public ResponseEntity<UserDto> userDashboard(@PathVariable("userId") int userId) throws IdNotFoundException{
		return new ResponseEntity<UserDto>(userService.getUserDashboard(userId),HttpStatus.OK);
	}
	
}
