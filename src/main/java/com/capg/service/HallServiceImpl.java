package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hall;
import com.capg.entity.Show;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.ScreenAlreadyExistsException;
import com.capg.repository.HallRepository;
import com.capg.repository.ShowRepository;
import com.capg.utility.AppConstant;

@Service
public class HallServiceImpl implements HallService {

	@Autowired
	private HallRepository hallRepository;
	
	
	public Hall addHall(Hall hall)
	{
		String existsHall = hall.getHallDescription().toLowerCase();
		List<Hall> allHalls = hallRepository.findAll();
		int flag=0;
		if(allHalls.size()<3) {
			if(existsHall.equals("screen1") || existsHall.equals("screen2") || existsHall.equals("screen3")) {
				for(Hall h: allHalls) {
					if(h.getHallDescription().toLowerCase().equals(existsHall)) {
						flag=1;
						throw new ScreenAlreadyExistsException(AppConstant.SCREEN_ALREADY_EXISTS_INFO);
					}
				}
				if(flag==0) {
					return hallRepository.save(hall);
				}
			}else {
				throw new ScreenAlreadyExistsException(AppConstant.INVALID_SCREEN_TYPE);
			}
		}
		throw new ScreenAlreadyExistsException(AppConstant.SCREEN_ALREADY_EXISTS_INFO);
			
	
	}

	public String deleteHallById(int hallId)
	{
		String message;
	if (hallRepository.existsById(hallId)) 
	{
		hallRepository.deleteById(hallId);
		message = "Hall successfully deleted";
	} else
	{
		throw new IdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
	}

	return message;
}


	public Hall getHallById(int hallId) {
		Optional<Hall> hallById=hallRepository.findById(hallId);
		if(hallById.isEmpty())
		{
			throw new IdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
		}
		return hallById.get();
	}

}
