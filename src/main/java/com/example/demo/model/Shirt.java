package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Entity
public class Shirt implements Serializable {


	private static final long serialVersionUID = -8830356203632241743L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String size;
	private String colour;
	private String type;
	private double price;


	public Shirt() {
	
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Shirt(String size, String colour, String type, @NonNull double price) {
		super();
		this.size = size;
		this.colour = colour;
		this.type = type;
		this.price = price;
	}
	
	

	
	



	
}
