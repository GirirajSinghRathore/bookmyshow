package com.example.bookmyshow.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
public class SignUpRequestDto {
    private String email;
    private String password;
    private String name;
}
