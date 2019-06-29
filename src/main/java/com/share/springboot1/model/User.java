package com.share.springboot1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String email;
	private String phone;
	private Integer age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String email, String phone, Integer age) {
		super();
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.age = age;
	}

	public User(Long id, String username, String email, String phone, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", phone=" + phone + ", age=" + age + "]";
	}

}
