package com.example.demo.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.demo.entity.User.Authority;
import com.example.demo.validation.UniqueUsername;

public class UserForm {
	@UniqueUsername
	@NotNull(message="ユーザー名を入力してください")
	@Length(min=4, max=50)
	private String username;
	
	
	@NotNull(message="パスワードを入力してください")
	@Length(min=12, max=128)
	private String password;
	
	@NotNull(message="権限を選択してください")
	private Authority authority;

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
}
