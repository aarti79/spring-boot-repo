package com.example.exception;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;
	
	@NotEmpty(message = "Name is mandatory")
	private String userName;
	
	private int age;
	private double salary;
	
	public User(long userId, @NotEmpty(message = "Name is mandatory") String userName, int age, double salary) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
		this.salary = salary;
	}
	public User() {
		super();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
