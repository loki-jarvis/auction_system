package com.auctionsystem.model;

public class User {
	
	private int uid;
	private String name;
	private String password;
	private String email;
	private int role;
	
	//We need one default constructor
	public User() {
		
	}

	//Normal constructor
	public User(int uid, String name, String password, String email, int role) {
		
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password + ", email=" + email + ", role=" + role
				+ "]";
	}
	

}
