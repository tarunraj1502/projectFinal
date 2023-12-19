package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.AdminDto;
import com.capg.dto.EarningsInputDto;
import com.capg.dto.EarningsOutputDto;
import com.capg.dto.MovieDto;
import com.capg.entity.Hall;
import com.capg.entity.Movie;
import com.capg.entity.SeatType;
import com.capg.entity.Show;
import com.capg.entity.ShowAvailability;
import com.capg.exception.IdNotFoundException;
import com.capg.service.AvailabilityServiceImpl;
import com.capg.service.EarningServiceImpl;
import com.capg.service.HallServiceImpl;
import com.capg.service.MovieServiceImpl;
import com.capg.service.SeatTypeServiceImpl;
import com.capg.service.ShowServiceImpl;
import com.capg.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private MovieServiceImpl movieService;
	
	@Autowired
	private HallServiceImpl hallService;
	
	@Autowired
	private ShowServiceImpl showService;
	
	@Autowired
	private SeatTypeServiceImpl seatTypeService;
	
    @Autowired
    private AvailabilityServiceImpl availabilityService;
    
    @Autowired
    private EarningServiceImpl earningsService;
    
	@PostMapping("/addMovie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.OK);
	}
	
	@DeleteMapping("/movie/{movieId}")
	public ResponseEntity<String> deleteMovieById(@PathVariable int movieId)
	{
		return new ResponseEntity<String>(movieService.deleteMovieById(movieId), HttpStatus.OK);
	}
	
	@GetMapping("/getAllMovie")
	public ResponseEntity<List<MovieDto>> getAllMovie() {
		return new ResponseEntity<List<MovieDto>>(movieService.getAllMovie(), HttpStatus.OK);
	}
	
	@PostMapping("/addHall")
	public ResponseEntity<Hall> addHall(@RequestBody Hall hall) 
	{
		return new ResponseEntity<Hall>(hallService.addHall(hall), HttpStatus.OK);
	}
	
	
	@GetMapping("/getHall/{hallId}")
	public ResponseEntity<Hall> getHall(@PathVariable int hallId)
	{
		return new ResponseEntity<Hall>(hallService.getHallById(hallId),HttpStatus.OK);
	}

	@DeleteMapping("/hall/{hallId}")
	public ResponseEntity<String> deleteHallById(@PathVariable int hallId) 
	{
		return new ResponseEntity<String>(hallService.deleteHallById(hallId), HttpStatus.OK);
	}
	@PostMapping("/addShow")
	public ResponseEntity<Show> addShows(@RequestBody Show show)
	{
		return new ResponseEntity<Show>(showService.addShow(show),HttpStatus.OK);
	}
	
	@DeleteMapping("/shows/{showId}")
	public ResponseEntity<String> deleteShow(@PathVariable int showId)
	{
		return new ResponseEntity<String>(showService.deleteShowsById(showId),HttpStatus.OK);
	}
	
	@PutMapping("/show/{showId}")
	public ResponseEntity<Show> updateShows(@PathVariable int showId,@RequestBody Show show)
	{
		return new ResponseEntity<Show>(showService.updateShow(showId,show),HttpStatus.OK);
	}

	@PostMapping("/addSeatType")
	public ResponseEntity<SeatType> addSeatType(@RequestBody SeatType seatType) {
		return new ResponseEntity<SeatType>(seatTypeService.addSeatType(seatType), HttpStatus.OK);
	}

	@DeleteMapping("/seatType/{seatId}")
	public ResponseEntity<String> deleteSeatTypeById(@PathVariable int seatId) {
		return new ResponseEntity<String>(seatTypeService.deleteSeatTypeById(seatId), HttpStatus.OK);
	}

	@GetMapping("/seatType")
	public ResponseEntity<List<SeatType>> getAllSeatType() {
		return new ResponseEntity<List<SeatType>>(seatTypeService.getAllSeatType(), HttpStatus.OK);
	}
	
	@PostMapping("/addShowAvail")
	public ResponseEntity<ShowAvailability> addShowAvailability(@RequestBody ShowAvailability showAvail)
	{
		return new ResponseEntity<ShowAvailability>(availabilityService.addShowAvailable(showAvail),HttpStatus.OK);
	}
	@DeleteMapping("/showAvail/{availId}")
	public ResponseEntity<String> deleteShowAvailability(@PathVariable int availId)
	{
		return new ResponseEntity<String>(availabilityService.deleteByAvailId(availId),HttpStatus.OK);
	}

	@PostMapping("/earningReport")
	public ResponseEntity<EarningsOutputDto> generateEarningsReport(@RequestBody EarningsInputDto earningsInputDto) {
		return new ResponseEntity<>(earningsService.generateEarningsReport(earningsInputDto), HttpStatus.OK);
	}
	
	@GetMapping("/admindashboard/{adminId}")
	public ResponseEntity<AdminDto> adminDashboard(@PathVariable("adminId") int adminId) throws IdNotFoundException{
		return new ResponseEntity<AdminDto>(userService.getAdminDashboard(adminId),HttpStatus.OK);
	}
	}
