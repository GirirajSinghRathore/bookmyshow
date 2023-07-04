package com.example.bookmyshow;

import com.example.bookmyshow.controller.UserController;
import com.example.bookmyshow.dtos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class BookmyshowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;



	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

	@Override
	public void run(String... args)  {
		SignUpResponseto signUpResponseto= userController.signUp(new SignUpRequestDto("gsr2@email.com","rthrt","Giriraj"));
		if(signUpResponseto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
			System.out.println("--------- SignUp Successful  --------");
		}else{
			System.out.println("--------- Oops could not SignIn  --------");
		}


		SignInResponseDto signInResponseDto = userController.signIn(new SignInRequestDto("gsr2@email.com","rthrt"));
		if(signInResponseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)){
			System.out.println("---------- Login SUccessful ------------");
		}else{
			System.out.println("---------- Login Failed ------------");
		}

	}
}
