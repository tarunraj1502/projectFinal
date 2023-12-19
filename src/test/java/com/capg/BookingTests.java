package com.capg;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.entity.SeatType;
import com.capg.entity.Show;
import com.capg.entity.User1;
import com.capg.repository.BookingRepository;
import com.capg.repository.SeatTypeRepository;
import com.capg.repository.ShowRepository;
import com.capg.repository.UserRepository;
import com.capg.service.BookingServiceimpl;
@SpringBootTest
public class BookingTests {

    @Mock
    private BookingRepository bookingRepository;
 
    @Mock
    private ShowRepository showsRepository;
 
    @Mock
    private UserRepository usersRepository;
 
    @Mock
    private SeatTypeRepository seatTypeRepository;
 

 
    @InjectMocks
    private BookingServiceimpl bookingService;
 
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
	
	
//	@Test
//    public void testBookingSeats() {
//        // Mocking the behavior of the repositories and entities
//        User1 user = new User1(); // Initialize with required values
//        Show show = new Show(); // Initialize with required values
//        SeatType seatType = new SeatType(); // Initialize with required values
//        List<SeatType> seatTypeList = new ArrayList<>();
//        seatTypeList.add(seatType);
// 
//        Booking booking = new Booking();
//        booking.setUsers(user);
//        booking.setShows(show);
//        booking.setSeatType(seatTypeList);
//        booking.setNoOfSeats(2);
//        booking.setShowDate(LocalDate.now().plusDays(2)); // Future date
// 
//        when(usersRepository.findById(anyInt())).thenReturn(Optional.of(user));
//        when(showsRepository.findById(anyInt())).thenReturn(Optional.of(show));
//        when(seatTypeRepository.findById(anyInt())).thenReturn(Optional.of(seatType));
//        when(bookingNewRepository.save(any())).thenReturn(booking);
// 
//        // Performing the actual test
//        Booking result = bookingService.bookingSeats(booking);
// 
//        // Assertions
//        assertNotNull(result);
//        // Add more assertions based on your specific logic
//    }
// 
//    // Add more test methods for other methods in BookingServiceImpl
// 
//}
 
}
