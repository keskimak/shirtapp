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

import com.example.demo.model.Shirt;
import com.example.demo.model.ShirtRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	

	@Bean
	public CommandLineRunner shirtAppDemo(ShirtRepository repository ) {
		return (args) -> {
			System.out.println("Saving to the database");
			Shirt shirt1 = new Shirt("M", "black", "jumper", 12.88);
			Shirt shirt2 = new Shirt("M", "blue", "t-shirt", 2.88);
			repository.save(shirt1);
			repository.save(shirt2);
			
			List<User> userList = new ArrayList<User>();
			PasswordEncoder passwordEncoder = encoder();
			User user1 = new User("user", null, "USER");
			User user2 = new User("admin", passwordEncoder.encode("vahvapassu"), "ADMIN");
			user1.setPasswordHash(passwordEncoder.encode("123"));
			userRepository.save(user1);
			userRepository.save(user2);
			User poika = userRepository.findByName("user");
			
			System.out.println(poika.getPasswordHash());
			
		};

	}

	
	
}
