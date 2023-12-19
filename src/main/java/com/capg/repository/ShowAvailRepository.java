package com.capg.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capg.entity.SeatType;
import com.capg.entity.Show;
import com.capg.entity.ShowAvailability;

public interface ShowAvailRepository extends JpaRepository<ShowAvailability, Integer>{
	
	//ShowAvailability findBySeatTypeAndAvailableDate(SeatType seatType, LocalDate localDate);
	
	ShowAvailability findBySeatTypeAndAvailableDateAndShow(SeatType seatType, LocalDate localDate,Show show);

	
	
	ShowAvailability findByAvailableDateAndShowAndSeatType(LocalDate localDate, Show show , SeatType seatType);


	

}
