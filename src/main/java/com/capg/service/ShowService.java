package com.capg.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.entity.Show;

public interface ShowService {

	Show addShow(Show show);
	String deleteShowsById(int showId);
	Show updateShow(int showId, Show show);
	Show getShowById(int showId);
	List<Show> getShowBetweenDates(LocalDate fromDate, LocalDate toDate);
	
}
