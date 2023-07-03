package com.example.bookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends  BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    private Date bookedAt;
    @ManyToOne
    private Show show;
    private Long amount;
    @OneToMany
    private List<Payment> payments;
}
