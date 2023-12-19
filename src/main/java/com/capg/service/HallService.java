package com.capg.service;

import com.capg.entity.Hall;

public interface HallService {
	
	Hall addHall(Hall hall);
	String deleteHallById(int hallId);
	Hall getHallById(int hallId);

}
