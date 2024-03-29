package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BuyEntity;
import com.example.demo.repository.AddDao;

@Service
public class AddServiceImpl implements AddService {
	
	private final AddDao dao;
	
	public AddServiceImpl(AddDao dao) {
		this.dao = dao;
	}

	// ドリンクの在庫を変更（追加）する
	@Override
	public void update(BuyEntity buy) {
		dao.update(buy);
	}

}
