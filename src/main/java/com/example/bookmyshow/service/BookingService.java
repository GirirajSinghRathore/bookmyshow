package com.example.bookmyshow.service;

import com.example.bookmyshow.model.*;
import com.example.bookmyshow.repository.BookingRepository;
import com.example.bookmyshow.repository.ShowRepository;
import com.example.bookmyshow.repository.ShowSeatRepository;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PriceCalculatorService priceCalculatorService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(List<Long> showSeatIds, Long userId, Long showId) throws Exception {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new Exception("User not found");
        }
        User bookedBy = userOptional.get();
        Optional<Show> showOptional = showRepository.findById(showId);
        if (showOptional.isEmpty()) {
            throw new Exception("Show not found");
        }
        Show bookedShow = showOptional.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat s : showSeats) {
            if (!(s.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ||
                    (s.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) && Duration.between(s.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes() > 15))) {
                throw new Exception("Seats Not Available");
            }
        }
        List<ShowSeat> saveSeats = new ArrayList<>();

        for (ShowSeat s : showSeats) {
            s.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            saveSeats.add(showSeatRepository.save(s));

        }
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(saveSeats);
        booking.setUser(bookedBy);
        booking.setBookedAt(new Date());
        booking.setShow(bookedShow);
        booking.setAmount(priceCalculatorService.calculatePrice(saveSeats,bookedShow));
        return bookingRepository.save(booking);
//        return null;
    }
}
