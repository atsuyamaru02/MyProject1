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
	
	//ドリンク一覧を取得
	@Override
	public List<BuyEntity> getAll() {
		List<BuyEntity> list = dao.getAll();
		return list;
	}

	//指定したIDのドリンク情報を取得
	@Override
	public BuyEntity getById(int id) {
		BuyEntity buy = dao.getById(id);
		return buy;
	}
	
	//ドリンク購入履歴を追加
	@Override
	public void sava(HistoryEntity history) {
		dao.insertHistory(history);
	}

	//ドリンク在庫を1つ減らす
	@Override
	public void reduceOne(int id) {
		dao.reduceOne(id);
	}

}
