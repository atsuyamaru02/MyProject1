package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BuyEntity;
import com.example.demo.entity.HistoryEntity;
import com.example.demo.repository.BuyDao;

@Service
public class BuyServiceImpl implements BuyService {

	private final BuyDao dao;
	
	public BuyServiceImpl(BuyDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<BuyEntity> getAll() {
		List<BuyEntity> list = dao.getAll();
		return list;
	}

	@Override
	public BuyEntity getById(int id) {
		BuyEntity buy = dao.getById(id);
		return buy;
	}
	
	@Override
	public void sava(HistoryEntity history) {
		dao.insertHistory(history);
	}

	@Override
	public void reduceOne(int id) {
		dao.reduceOne(id);
	}

}
