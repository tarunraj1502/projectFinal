package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Hall;
import com.capg.entity.SeatType;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.ScreenAlreadyExistsException;
import com.capg.exception.SeatAlreadyExistsException;
import com.capg.repository.SeatTypeRepository;
import com.capg.utility.AppConstant;

@Service
public class SeatTypeServiceImpl implements SeatTypeService{

	@Autowired
	private SeatTypeRepository seatTypeRepository;

	public SeatType addSeatType(SeatType seatType) {
		String seatDesc=seatType.getSeatTypeDescription().toLowerCase();
		List<SeatType> seatList= seatTypeRepository.findAll();
		int flag=0;
		if(seatList.size()<3) {
			if(seatDesc.equals("normal") || seatDesc.equals("premium") || seatDesc.equals("executive")) {
				for(SeatType seat: seatList) {
					if(seat.getSeatTypeDescription().toLowerCase().equals(seatDesc)) {
						flag=1;
						 throw new SeatAlreadyExistsException(AppConstant.SEAT_ALREADY_EXISTS_INFO);	
					}
				}
				if(flag==0) {
					return seatTypeRepository.save(seatType);
				}
			}else {
				throw new SeatAlreadyExistsException(AppConstant.INVALID_SEAT_TYPE);
			}
		}
		throw new SeatAlreadyExistsException(AppConstant.SEAT_ALREADY_EXISTS_INFO);
	}

	public String deleteSeatTypeById(int seatId) {
		String message = "";
		if (seatTypeRepository.existsById(seatId)) {
			seatTypeRepository.deleteById(seatId);
			message = "Seat successfully deleted";
		} else {
			throw new IdNotFoundException(AppConstant.SEAT_ID_NOT_FOUND_INFO);
		}
		return message;
	}

	public List<SeatType> getAllSeatType() {
		return seatTypeRepository.findAll();
	}
}
