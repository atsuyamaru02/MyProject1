package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.HistoryEntity;

public interface HistoryDao {
//	void insertHistory(History history);
	List<HistoryEntity> getAll();
}
