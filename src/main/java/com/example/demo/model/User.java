package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nullable;
import jakarta.persistence.*; 



@Entity
@Table(name = "users")
public class User {

		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "passwordHash")
	private String passwordHash;
	@Column(name = "role")
	private String role;
	
	//private User poika;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "budget_id", referencedColumnName = "id")
	private Budget budget;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Shirt> shirts;
	
	public User() {
		
	}	

	public User(String name, String passwordHash, String role) {
		super();
		this.name = name;
		this.passwordHash = passwordHash;
		this.role = role;
		Budget userbudget = new Budget();
		this.budget=userbudget;
		List<Shirt> shirts = new ArrayList<Shirt>();
		this.shirts=shirts;
		
		System.out.println(budget.getId());

	}
	
	public void buyShirt(Shirt shirt) {
		
		shirts.add(shirt);
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public User getPoika() {
//		return poika;
//	}
//
//	public void setPoika(User poika) {
//		this.poika = poika;
//	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public List<Shirt> getShirts() {
		return shirts;
	}

	public void setShirts(List<Shirt> shirts) {
		this.shirts = shirts;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwordHash=" + passwordHash + ", role=" + role + ", poika="
				+  "]";
	}

	



}
