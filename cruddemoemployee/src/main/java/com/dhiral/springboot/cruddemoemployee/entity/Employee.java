package com.dhiral.springboot.cruddemoemployee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	
	// define fields 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String fist_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	// define constructor
	public Employee() {}

	public Employee( String fist_name, String last_name, String email) {
		super();
		this.fist_name = fist_name;
		this.last_name = last_name;
		this.email = email;
	}
	
	// getter and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFist_name() {
		return fist_name;
	}

	public void setFist_name(String fist_name) {
		this.fist_name = fist_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fist_name=" + fist_name + ", last_name=" + last_name + ", email=" + email
				+ "]";
	}
	
	// to string
	
	
	
	
}
