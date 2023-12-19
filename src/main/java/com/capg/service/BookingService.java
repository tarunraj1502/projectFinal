package com.capg.service;

import com.capg.dto.BookingDto;
import com.capg.entity.Booking;

public interface BookingService {

	Booking createNewBooking(BookingDto bookingDto);
	String cancelBookingNew(int bookingId) ;

}
