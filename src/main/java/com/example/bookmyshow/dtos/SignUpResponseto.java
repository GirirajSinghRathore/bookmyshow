package com.example.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseto {
    private ResponseStatus responseStatus;
    private Long userId;
}
