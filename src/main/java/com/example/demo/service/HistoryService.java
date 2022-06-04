package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.HistoryEntity;

public interface HistoryService {
//	void sava(History history);
	
	//購入履歴データを全て取得する
	List<HistoryEntity> getAll();
}
