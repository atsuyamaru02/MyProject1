package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HistoryEntity;
import com.example.demo.repository.HistoryDao;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	private final HistoryDao dao;
	
	
	public HistoryServiceImpl(HistoryDao dao) {
		this.dao = dao;
	}

	//購入履歴一覧を取得
	@Override
	public List<HistoryEntity> getAll() {
		List<HistoryEntity> list = dao.getAll();
		return list;
	}

}
