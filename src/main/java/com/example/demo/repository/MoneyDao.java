package com.example.demo.repository;

import com.example.demo.entity.MoneyEntity;

public interface MoneyDao {
	MoneyEntity haveMoney();
	
	void increase(MoneyEntity money);
	
	void reduce(MoneyEntity money);
	
	boolean stock();
}
