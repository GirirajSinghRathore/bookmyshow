package com.example.bookmyshow.service;

import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeat;
import com.example.bookmyshow.model.ShowSeatType;
import com.example.bookmyshow.repository.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PriceCalculatorService {
    @Autowired
    private ShowSeatTypeRepository showSeatTypeRepository;

    public long calculatePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        Long amount = 0L ;
        for(ShowSeatType seatType : showSeatTypes){
            for(ShowSeat seat : showSeats){
                if(seat.getSeat().getSeatType().equals(seatType.getSeatType())){
                    amount+=seatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
