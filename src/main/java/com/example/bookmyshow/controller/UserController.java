package com.example.bookmyshow.controller;

import com.example.bookmyshow.dtos.ResponseStatus;
import com.example.bookmyshow.dtos.SignUpRequestDto;
import com.example.bookmyshow.dtos.SignUpResponseto;
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
            User u = userService.signUp(signUpRequestDto.getUsername(),signUpRequestDto.getPassword());
            signUpResponseto.setUserId(u.getId());
            signUpResponseto.setResponseStatus(ResponseStatus.SUCCESS);
            return signUpResponseto;
        } catch (Exception e) {
            signUpResponseto.setResponseStatus(ResponseStatus.FAILURE);
            return signUpResponseto;

        }
    }
}
