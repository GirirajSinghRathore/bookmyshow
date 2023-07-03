package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookingReqDto {
    private List<Long> showSeatIds;
    private Long userId;
    private Long showId;


}
