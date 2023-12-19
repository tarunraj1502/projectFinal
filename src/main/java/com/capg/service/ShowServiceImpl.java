package com.capg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hall;
import com.capg.entity.Show;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidSlotNoException;
import com.capg.exception.ShowAlreadyRunningException;
import com.capg.repository.HallRepository;
import com.capg.repository.ShowRepository;
import com.capg.utility.AppConstant;

@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private HallRepository hallRepository;

	public Show addShow(Show show) {
		Hall hall = show.getHall();
		if (!((show.getSlotNo().equals("S01")) || (show.getSlotNo().equals("S02")) || (show.getSlotNo().equals("S03")))) {
			throw new InvalidSlotNoException(AppConstant.INVALID_SLOT_NO_INFO);
		}
		LocalDate fromDate = show.getFromDate();
		LocalDate toDate = show.getToDate();
		List<Show> existingShows = showRepository.findByHallAndSlotNoAndFromDateGreaterThanEqualAndToDateLessThanEqual(
				hall, show.getSlotNo(), fromDate, toDate);
		if (!existingShows.isEmpty()) {
			throw new ShowAlreadyRunningException(AppConstant.SHOW_ALREADY_RUNNING_INFO);
		}
		return showRepository.save(show);

	}

	public String deleteShowsById(int showId) {
		String message;
		if (showRepository.existsById(showId)) {
			showRepository.deleteById(showId);
			message = "show successfully deleted";
		} else {
			throw new IdNotFoundException(AppConstant.SHOW_ID_NOT_FOUND_INFO);
		}

		return message;
	}

	public Show updateShow(int showId, Show show) {

		if (showRepository.existsById(showId)) {
			show.setShowId(showId);
		} else {
			throw new IdNotFoundException(AppConstant.SHOW_ID_NOT_FOUND_INFO);
		}

		return showRepository.save(show);
	}

	public Show getShowById(int showId) {
		Optional<Show> showById = showRepository.findById(showId);
		return showById.get();
	}

	@Override

	public List<Show> getShowBetweenDates(LocalDate fromDate, LocalDate toDate) {
		return showRepository.findShowsByDateRange(fromDate,toDate);
	}

}
