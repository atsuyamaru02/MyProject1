package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.BuyEntity;
import com.example.demo.entity.HistoryEntity;


public interface BuyDao {
	List<BuyEntity> getAll();
	
	BuyEntity getById(int id);
	
	void insertHistory(HistoryEntity history);
	
	void reduceOne(int id);
}
