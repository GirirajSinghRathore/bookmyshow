package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BookingReqResponseDto {
    private ResponseStatus responseStatus;
    private long amount;
    private Long bookingId;

}
