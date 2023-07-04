package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.*;
import com.example.bookmyshow.model.User;
import com.example.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public SignUpResponseto signUp(SignUpRequestDto signUpRequestDto){
        SignUpResponseto signUpResponseto= new SignUpResponseto();
        try {
            User u = userService.signUp(signUpRequestDto.getEmail(),signUpRequestDto.getPassword(),signUpRequestDto.getName());
            signUpResponseto.setUserId(u.getId());
            signUpResponseto.setResponseStatus(ResponseStatus.SUCCESS);
            return signUpResponseto;
        } catch (Exception e) {
            signUpResponseto.setResponseStatus(ResponseStatus.FAILURE);
            return signUpResponseto;

        }
    }
    public SignInResponseDto signIn(SignInRequestDto signInRequestDto){
        SignInResponseDto signInResponseDto = new SignInResponseDto();
        try{
            User u = userService.signIn(signInRequestDto.getEmail(),signInRequestDto.getPassword());
            signInResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            signInResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signInResponseDto;
    }
}
