package com.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter@Entity
public class Payment extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private Provider provider;
    private String referenceNumber;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private Long amount;
}
