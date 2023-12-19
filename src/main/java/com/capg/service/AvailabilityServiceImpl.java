package com.capg.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hall;
import com.capg.entity.Movie;
import com.capg.entity.SeatType;
import com.capg.entity.Show;
import com.capg.entity.ShowAvailability;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.ShowAlreadyRunningException;
import com.capg.exception.ShowNotInRangeException;
import com.capg.repository.HallRepository;
import com.capg.repository.MovieRepository;
import com.capg.repository.SeatTypeRepository;
import com.capg.repository.ShowAvailRepository;
import com.capg.repository.ShowRepository;
import com.capg.utility.AppConstant;
@Service
public class AvailabilityServiceImpl implements AvailabilityService {

	@Autowired
	private ShowAvailRepository availabilityRepository;
	
	@Autowired
	private ShowRepository showReposiotry;
	
	@Autowired
	private HallRepository hallRepository;
	
	@Autowired
	private MovieRepository movieReposiotry;
	
	@Autowired
	private SeatTypeRepository seatTypeRepository;
	
	public ShowAvailability addShowAvailable(ShowAvailability showAvail) {
		Hall hall=hallRepository.findById(showAvail.getHall().getHallId())
				.orElseThrow(()->new IdNotFoundException("HALL_ID_IS_NOT_FOUND"));
			Show show1=showReposiotry.findById(showAvail.getShow().getShowId())
					.orElseThrow(()-> new IdNotFoundException("SHOW_ID_NOT_FOUND"));
			Movie movie=movieReposiotry.findById(showAvail.getMovie().getMovieId())
					.orElseThrow(()->new IdNotFoundException("MOVIE_ID_NOT_FOUND"));
			SeatType seatType=seatTypeRepository.findById(showAvail.getSeatType().getSeatTypeId())
					.orElseThrow(()->new IdNotFoundException("SEAT_TYPE_ID_NOT_FOUND"));
			ShowAvailability showAvaill=new ShowAvailability();
		LocalDate availableDate=showAvail.getAvailableDate();
		System.out.println(availableDate);
		int seatId=showAvail.getSeatType().getSeatTypeId();
		Show show=showAvail.getShow();
		ShowAvailability existingAvailability=availabilityRepository.findByAvailableDateAndShowAndSeatType(availableDate,  show , seatType);
		
		 if(!(availableDate.minusDays(1).isBefore(show1.getToDate())&&availableDate.plusDays(1).isAfter(show1.getFromDate())))
		{
			throw new ShowNotInRangeException(AppConstant.SHOW_NOT_IN_RANGE_INFO);
		}
		 else if(existingAvailability!=null)
		{
				throw new ShowAlreadyRunningException(AppConstant.SHOW_ALREADY_RUNNING_INFO);
		}
			
		return availabilityRepository.save(showAvail);
	}
	
	public String deleteByAvailId(int availId)
	{
		String message="";
		if(availabilityRepository.existsById(availId))
		{
			availabilityRepository.deleteById(availId);
			message="Show successfully deleted";
		}
		else
		{
			throw new IdNotFoundException(AppConstant.SHOW_ID_NOT_FOUND_INFO);
		}
		return message;
	}

	
	

	

}
