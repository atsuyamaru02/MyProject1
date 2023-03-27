package com.example.demo.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserInfoDao;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	private final UserInfoDao dao;
	private final PasswordEncoder passwordEncoder;
	
	public UserInfoServiceImpl(UserInfoDao dao, PasswordEncoder passwordEncoder) {
		this.dao = dao;
		this.passwordEncoder = passwordEncoder;
	}
	
	// ユーザーを追加する
	@Override
	public void addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.insertUser(user);
	}

	// 全ユーザーを取得する
	@Override
	public List<User> getAll() {
		List<User> list = dao.getAll();
		return list;
	}

}
