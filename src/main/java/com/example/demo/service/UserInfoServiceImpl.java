package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserInfoDao;
@Service
public class UserInfoServiceImpl implements UserInfoService {

	private final UserInfoDao dao;
	
	public UserInfoServiceImpl(UserInfoDao dao) {
		this.dao = dao;
	}
	
	// ユーザー追加処理
	@Override
	public void addUser(User user) {
		dao.insertUser(user);
	}

	@Override
	public List<User> getAll() {
		List<User> list = dao.getAll();
		return list;
	}

}
