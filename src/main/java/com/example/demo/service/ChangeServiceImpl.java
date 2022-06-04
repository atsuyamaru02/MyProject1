package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BuyEntity;
import com.example.demo.repository.ChangeDao;

@Service
public class ChangeServiceImpl implements ChangeService {
	
	private final ChangeDao dao;
	
	public ChangeServiceImpl(ChangeDao dao) {
		this.dao = dao;
	}
	@Override
	public void update(BuyEntity buy) {
		// TODO 自動生成されたメソッド・スタブ
		dao.update(buy);
	}

}
