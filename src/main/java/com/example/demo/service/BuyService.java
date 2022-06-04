package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.BuyEntity;
import com.example.demo.entity.HistoryEntity;

public interface BuyService {
	//商品データを全て取得する
	List<BuyEntity> getAll();
	
	//対象IDのデータを取得する
	BuyEntity getById(int id);
	
	//商品購入履歴に購入商品を追加する
	void sava(HistoryEntity history);
	
	//商品購入したらstockを１つ
	void reduceOne(int id);
}
