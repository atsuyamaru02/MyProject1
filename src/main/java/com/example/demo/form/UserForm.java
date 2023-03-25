package com.example.demo.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class UserForm {
	@NotNull(message="ユーザー名を入力してください")
	@Length(min=4, max=50)
	private String username;
	
	
	@NotNull(message="パスポートを入力してください")
	@Length(min=12, max=128)
	private String password;


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

}
