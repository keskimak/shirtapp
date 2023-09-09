package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Shirt;
import com.example.demo.model.ShirtRepository;
import com.example.demo.model.User;

import com.example.demo.model.UserRepository;

@Controller
public class ShirtController {
	

	List<Shirt> shirtList = new ArrayList<Shirt>();
	@Autowired
	private ShirtRepository repository;
	
	List<User> userList = new ArrayList<User>();
	@Autowired
	private UserRepository userRepository;

	// Lists shirts
	@RequestMapping("/shirtlist")
	public String listBooks(@ModelAttribute Shirt shirt, Model model) {
		
		model.addAttribute("shirtList", repository.findAll());
		return "shirtlist";

	}

	// Return in JSON
	@RequestMapping(value = "/shirts", method = RequestMethod.GET)
	public @ResponseBody List<Shirt> shirtListRest() {
		return (List<Shirt>) repository.findAll();
	}
	
	// Return in JSON
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> userListRest() {
		return (List<User>) userRepository.findAll();
	}


	// Return by id in JSON
	@RequestMapping(value = "/shirt/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Shirt> findShirtRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	// Return user id in JSON
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<User> findUsersRest(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}

	// Add new shirt to the database
	@RequestMapping("/addshirt")
	public String addShirt(@Validated Model model) {
		model.addAttribute("shirt", new Shirt());

		
		return "addshirt";
	}

	@PostMapping("/save")
	public String saveShirt(Shirt shirt) {
		repository.save(shirt);
		return "redirect:shirtlist";

	}
	
	@GetMapping("/error")
	public String errorPage() {
		return "error";
	}
	
	@RequestMapping(value ="/login")
	public String loginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(User user) {

		userRepository.save(user);
		return "redirect:shirtlist";

	}

	@RequestMapping(value = "/edit/{id}")
	public String addBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("shirt", repository.findById(id));

		return "edit";
	}	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteShirt(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../shirtlist";
	}


}
