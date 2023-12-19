package com.capg.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.entity.Show;
import com.capg.entity.ShowAvailability;

public interface AvailabilityService {

	ShowAvailability addShowAvailable(ShowAvailability showAvail);
	
}
