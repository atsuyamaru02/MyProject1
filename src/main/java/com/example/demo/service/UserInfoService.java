package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserInfoService {
	void addUser(User user);
	
	List<User> getAll();
}
