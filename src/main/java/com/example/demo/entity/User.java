package com.example.demo.entity;

public class User {
	
	private String username;
	private String password;
	private Authority authority;
	
	public enum Authority {
		DRINK,
		MONEY,
		INFOADMIN
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public User(String username, String password, Authority authority) {
		this.username = username;
		this.password = password;
		this.authority = authority;
	}


}
