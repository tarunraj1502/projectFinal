package com.capg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.BookingDto;
import com.capg.entity.Booking;
import com.capg.entity.EarningReport;
import com.capg.entity.SeatType;
import com.capg.entity.Show;
import com.capg.entity.ShowAvailability;
import com.capg.entity.User1;
import com.capg.exception.BookingAlreadyCancelledException;
import com.capg.exception.CannotCancelException;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.SeatNotAvailableException;
import com.capg.exception.ShowDateNotFoundException;
import com.capg.exception.ShowNotAvailable;
import com.capg.repository.BookingRepository;
import com.capg.repository.EarningReportRepository;
import com.capg.repository.HallRepository;
import com.capg.repository.SeatTypeRepository;
import com.capg.repository.ShowAvailRepository;
import com.capg.repository.ShowRepository;
import com.capg.repository.UserRepository;
import com.capg.utility.AppConstant;

@Service
public class BookingServiceimpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private SeatTypeRepository seatTypeRepository;
	
	@Autowired
	private ShowAvailRepository showAvailRepository;
	
	@Autowired
	private HallRepository hallRepository;
	@Autowired
	private EarningReportRepository earningReportRepository;
	
	@Override
	public Booking createNewBooking(BookingDto bookingDto) {
		Booking bookingNew = new Booking();
		User1 user = userRepository.findById(bookingDto.getUserId()).orElseThrow(
				() -> new IdNotFoundException("USER NOT FOUND  WITH ID: " + bookingDto.getUserId()));
		
		Show show1 = showRepository.findById(bookingDto.getShowId()).orElseThrow(
				() -> new IdNotFoundException("SHOW NOT FOUND WITH ID: " + bookingDto.getShowId()));
	 Optional	<SeatType> seatType = seatTypeRepository.findById(bookingDto.getSeatTypeId());
		if(seatType == null) {
			throw new IdNotFoundException("SEAT TYPE  NOT FOUND WITH ID");
		}
		LocalDate fromDate1 = show1.getFromDate();
		LocalDate toDate1 = show1.getToDate();
		
		if (bookingDto.getShowDate().isBefore(LocalDate.now())||bookingDto.getShowDate().isBefore(bookingDto.getBookingDate())) {
			throw new ShowDateNotFoundException(AppConstant.BEFORE_BOOKING_DATE_INFO);
		} else if (!bookingDto.getShowDate().minusDays(1).isBefore(toDate1)
				&& bookingDto.getShowDate().plusDays(1).isAfter(fromDate1)) {
			throw new ShowDateNotFoundException(AppConstant.SHOW_NOT_IN_RANGE_INFO);
		}
		else {

			ShowAvailability showAvailable =	showAvailRepository.findBySeatTypeAndAvailableDateAndShow(seatType.get(), bookingDto.getShowDate(),show1);

System.out.println("--------------"+showAvailable);
			if(showAvailable==null)
			    throw new ShowNotAvailable(AppConstant.SHOW_IS_NOT_AVAILABLE_INFO);
			else if(showAvailable.getRemainingSeat()<bookingDto.getNoOfSeats())
			{
				throw new  SeatNotAvailableException(AppConstant.SEAT_NOT_AVAILABLE_INFO);
			}
			else
			{
			bookingNew.setUserId(bookingDto.getUserId());
			bookingNew.setUserName(user.getUserName());
			bookingNew.setMovieName(show1.getMovie().getMovieName());
			bookingNew.setBookedDate(LocalDate.now());
			bookingNew.setShowId(show1.getShowId());
			bookingNew.setShowDate(bookingDto.getShowDate());
			bookingNew.setSeatDescription(seatType.get().getSeatTypeDescription());
			bookingNew.setSeatFare(seatType.get().getSeatFare());
			bookingNew.setNoOfSeats(bookingDto.getNoOfSeats());
			bookingNew.setBookingAmount(bookingDto.getNoOfSeats() * seatType.get().getSeatFare());
		
			
            System.out.println("remaining seat :"+ showAvailable.getRemainingSeat());
            
            int remainingSeat = showAvailable.getRemainingSeat()-bookingDto.getNoOfSeats();
            showAvailable.setRemainingSeat(remainingSeat);
            System.out.println("after booking remaining seat :"+ remainingSeat);
            
			showAvailRepository.save(showAvailable);
			}	
			
		Booking booking =	bookingRepository.save(bookingNew);
			
		earningReportRepository.save(new EarningReport(booking.getBookingId(), "booked", bookingNew.getBookingAmount(), bookingNew.getNoOfSeats(), bookingNew.getBookedDate()));
			
			return booking;
			
		}
	}

	public String cancelBookingNew(int bookingId) {
		String message="";
		LocalDate currentDate = LocalDate.now();
		Optional<Booking> opBookingNew = bookingRepository.findById(bookingId);
		if(opBookingNew.isEmpty()) throw new IdNotFoundException(AppConstant.BOOKING_ID_NOT_FOUND);
		Booking bookingNew = opBookingNew.get();
		int tempSeatId=0;
		if(bookingNew.getBookingOrderStatus().equals("CANCELLED"))
		{
			throw new BookingAlreadyCancelledException(AppConstant.CANCELLED_SEATS_INFO);
		}
		if (currentDate.until(bookingNew.getShowDate()).getDays() > 2) {
			int seats = bookingNew.getNoOfSeats();
			Optional<Show> opShow = showRepository.findById(bookingNew.getShowId());
			Show show = opShow.get();
			List<SeatType> seatList= seatTypeRepository.findAll();
			for(SeatType seat:seatList)
			{
				if(bookingNew.getSeatDescription().equals(seat.getSeatTypeDescription()))
				{
					tempSeatId=seat.getSeatTypeId();
				}
			}


			
			SeatType seatType = new SeatType();
			seatType.setSeatTypeId(tempSeatId);
			
	ShowAvailability showAvailability =		showAvailRepository.findByAvailableDateAndShowAndSeatType(bookingNew.getShowDate(), show,seatType);
	  System.out.println("----showAvailability "+ showAvailability);	
	  System.out.println("-- "+ showAvailability.getAvailabilityId());
	  System.out.println(bookingNew.getNoOfSeats());
	    int updateSeat = showAvailability.getRemainingSeat() + bookingNew.getNoOfSeats();
	    System.out.println("----"+ updateSeat);
	    showAvailability.setRemainingSeat(updateSeat);
	    
	    showAvailRepository.save(showAvailability);
	    
	    bookingNew.setBookingOrderStatus("CANCELLED");
	    
	    
	       

	     	bookingRepository.save(bookingNew);
	     	bookingNew.setNoOfSeats(0);
			Optional<EarningReport> opEarningReport = earningReportRepository.findByBookingId(bookingId);
			if(opEarningReport.isEmpty()) throw new RuntimeException("exception");
			EarningReport earningReport = opEarningReport.get();
			earningReport.setStatus("cancelled");
			earningReport.setBookingId(bookingId);
			earningReportRepository.save(earningReport);
			message= "Booking Cancellation Successfull";
		} else {
			throw new CannotCancelException(AppConstant.CANNOT_CANCEL_INFO);
		}
		return message;
}
}