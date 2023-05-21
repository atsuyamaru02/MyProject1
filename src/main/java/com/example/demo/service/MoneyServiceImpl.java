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

	// 紙幣・貨幣の追加
	@Override
	public void increase(MoneyEntity money) {
		dao.increase(money);
	}

	// 紙幣・貨幣の回収
	@Override
	public void reduce(MoneyEntity money) {
		dao.reduce(money);
	}

	// おつりが出せる状況かどうかの取得
	@Override
	public boolean stock() {
		return dao.stock();
	}

	// 紙幣・貨幣の各枚数取得
	@Override
	public MoneyEntity haveMoney() {
		return dao.haveMoney();
	}

	// 値が0以上かどうか
	@Override
	public boolean zeroAndNaturalNumber(int number) {
		if(0 <= number) {
			return true;
		}
		return false;
	}

}
