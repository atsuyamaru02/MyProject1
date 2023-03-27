package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserInfoService {
	// ユーザーを追加する
	void addUser(User user);
	
	// 全ユーザーを取得する
	List<User> getAll();
}
