package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.User;

public interface UserInfoDao {
	void insertUser(User user);
	
	List<User> getAll();
}
