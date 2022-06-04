package com.example.demo.service;

import com.example.demo.entity.MoneyEntity;

public interface MoneyService {
	MoneyEntity haveMoney();
	
	void increase(MoneyEntity money);
	
	void reduce(MoneyEntity money);
	
	boolean stock();
	
	boolean zeroAndNaturalNumber(int number);
}
