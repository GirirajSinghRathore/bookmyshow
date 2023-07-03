package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.BookingReqDto;
import com.example.bookmyshow.dtos.BookingReqResponseDto;
import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.model.Booking;
import com.example.bookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

public class BoookingController {
    @Autowired
    private BookingService bookingService;

    public BookingReqResponseDto bookTicket(BookingReqDto bookingReqDto){
        BookingReqResponseDto bookingReqResponseDto = new BookingReqResponseDto();
        Booking booking = null;
        try {
            booking = bookingService.bookMovie(bookingReqDto.getShowSeatIds(),bookingReqDto.getUserId(),bookingReqDto.getShowId());
        } catch (Exception e) {
            bookingReqResponseDto.setResponseStatus(ResponseStatus.FAILURE);

            return bookingReqResponseDto;
        }
        bookingReqResponseDto.setBookingId(booking.getId());
        bookingReqResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        bookingReqResponseDto.setAmount(booking.getAmount());
        return bookingReqResponseDto;


    }
}
