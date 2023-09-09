package com.example.demo.model;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import jakarta.persistence.*;



@jakarta.persistence.Entity
@Table(name="usertable")
public class User implements Serializable{
	
	private static final long serialVersionUID = -8830356203632241743L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String passwordHash;
	
	private String role;
	

	public User() {
		
	}

	public User(String name, String passwordHash, String role) {
		super();
		this.name = name;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwordHash=" + passwordHash + ", role=" + role + "]";
	}
	
	
	
	

}
