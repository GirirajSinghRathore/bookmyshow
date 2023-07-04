package com.example.bookmyshow.service;

import com.example.bookmyshow.model.User;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    UserRepository userRepository;
    public User signUp(String email, String password,String name) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new Exception("User already Exists");
        }
        User u = new User();
        u.setEmail(email);
        u.setPassword(bCryptPasswordEncoder.encode(password));
        u.setName(name);
        u.setBookings(new ArrayList<>());
        return userRepository.save(u);

    }

    public User signIn(String email, String password) throws Exception {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new Exception("User Not Found");
        }
        boolean success = bCryptPasswordEncoder.matches(password,user.get().getPassword());
        if(success){
            return user.get();
        }else{
            throw new Exception("Incorrect Password");
        }

    }
}
