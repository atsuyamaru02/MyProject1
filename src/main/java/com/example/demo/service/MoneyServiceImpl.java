package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.MoneyEntity;
import com.example.demo.repository.MoneyDao;

@Service
public class MoneyServiceImpl implements MoneyService {
	private final MoneyDao dao;
	
	public MoneyServiceImpl(MoneyDao dao) {
		this.dao = dao;
	}

	@Override
	public void increase(MoneyEntity money) {
		dao.increase(money);
	}

	@Override
	public void reduce(MoneyEntity money) {
		dao.reduce(money);
	}

	@Override
	public boolean stock() {
		return dao.stock();
	}

	@Override
	public MoneyEntity haveMoney() {
		return dao.haveMoney();
	}

	@Override
	public boolean zeroAndNaturalNumber(int number) {
		if(0 <= number) {
			return true;
		}
		return false;
	}

}
