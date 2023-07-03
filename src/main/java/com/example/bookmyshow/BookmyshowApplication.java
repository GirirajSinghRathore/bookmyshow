package com.example.bookmyshow;

import com.example.bookmyshow.controller.UserController;
import com.example.bookmyshow.dtos.SignUpRequestDto;
import com.example.bookmyshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaAuditing
@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;


	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userController.signUp(new SignUpRequestDto("wesww",bCryptPasswordEncoder.encode("rthrt")));
	}
}
