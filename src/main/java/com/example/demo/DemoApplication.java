package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Budget;
import com.example.demo.model.BudgetRepository;
import com.example.demo.model.Shirt;
import com.example.demo.model.ShirtRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BudgetRepository budgetRepository;
	
	@Autowired
	ShirtRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	

	@Bean
	public CommandLineRunner shirtAppDemo( ) {
		return (args) -> {
			System.out.println("Saving to the database");
	

		
			PasswordEncoder passwordEncoder = encoder();
			User user1 = new User("poika", passwordEncoder.encode("123"), "USER");
			User user2 = new User("faija", passwordEncoder.encode("vahvapassu"), "ADMIN");
			
			//user2.setPoika(user1);
			userRepository.save(user1);
			userRepository.save(user2);
//			User poika = userRepository.findByName("poika");
//			System.out.println(poika.getPasswordHash());
			
			Shirt shirt1 = new Shirt("M", 12.88, user1);
			Shirt shirt2 = new Shirt("M",  2.88, user1);
			repository.save(shirt1);
			repository.save(shirt2);
			
			user1.buyShirt(shirt1);	user1.buyShirt(shirt2);
			
			
			
		};

	}

	
	
}
