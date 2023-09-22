package com.example.demo.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shirt;
import com.example.demo.model.ShirtRepository;

@RestController
@RequestMapping("/shirtsjson")
public class JSONController {
	
	@Autowired
	ShirtRepository sh;
	
	   @GetMapping(path = "/shirts", produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Shirt>  getShirts() {
	        List < Shirt > shirts = (List<Shirt>) sh.findAll();
	        return shirts;
	    }
	

}
