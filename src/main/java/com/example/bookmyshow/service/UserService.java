package com.example.bookmyshow.service;

import com.example.bookmyshow.model.User;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User signUp(String email, String password) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isEmpty()){
            throw new Exception("User already Exists");
        }
        User u = new User();
        u.setEmail(email);
        u.setPassword(password);
        u.setBookings(new ArrayList<>());
        return userRepository.save(u);

    }
}
