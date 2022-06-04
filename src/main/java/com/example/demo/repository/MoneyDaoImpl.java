package com.example.demo.repository;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MoneyEntity;

@Repository
public class MoneyDaoImpl implements MoneyDao {

	private final JdbcTemplate jdbcTemplate;

	public MoneyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void increase(MoneyEntity money) {
		String sql = "SELECT * FROM vendingmachine.money;";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);
		
		MoneyEntity haveMoney = new MoneyEntity();
		
		haveMoney.setThousand((int)result.get("thousand"));
		haveMoney.setFiveHundred((int)result.get("fiveHundred"));
		haveMoney.setOneHundred((int)result.get("oneHundred"));
		haveMoney.setFifty((int)result.get("fifty"));
		haveMoney.setTen((int)result.get("ten"));
		
		
		jdbcTemplate.update("UPDATE money SET thousand=?, fiveHundred=?, oneHundred=?, fifty=?, ten=?",
				money.getThousand() + haveMoney.getThousand(), money.getFiveHundred() + haveMoney.getFiveHundred(), 
				money.getOneHundred() + haveMoney.getOneHundred(), money.getFifty() + haveMoney.getFifty(), money.getTen() + haveMoney.getTen());
		
	}

	@Override
	public void reduce(MoneyEntity money) {
		String sql = "SELECT * FROM vendingmachine.money;";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);
		
		MoneyEntity haveMoney = new MoneyEntity();
		
		haveMoney.setThousand((int)result.get("thousand"));
		haveMoney.setFiveHundred((int)result.get("fiveHundred"));
		haveMoney.setOneHundred((int)result.get("oneHundred"));
		haveMoney.setFifty((int)result.get("fifty"));
		haveMoney.setTen((int)result.get("ten"));
		
		
		jdbcTemplate.update("UPDATE money SET thousand=?, fiveHundred=?, oneHundred=?, fifty=?, ten=?",
				haveMoney.getThousand() - money.getThousand(), haveMoney.getFiveHundred() - money.getFiveHundred(), 
				haveMoney.getOneHundred() - money.getOneHundred() , haveMoney.getFifty() - money.getFifty() , haveMoney.getTen() - money.getTen());
		
	}

	@Override
	public boolean stock() {
		String sql = "SELECT * FROM vendingmachine.money;";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);
		
		MoneyEntity haveMoney = new MoneyEntity();
		
		int thousand = (int)result.get("thousand");
		int fiveHundred = (int)result.get("fiveHundred");
		int oneHundred = (int)result.get("oneHundred");
		int fifty = (int)result.get("fifty");
		int ten = (int)result.get("ten");
		
		if((1 <= thousand) && (1 <= fiveHundred) && (4 <= oneHundred) && (1 <= fifty) && (4 <= ten)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public MoneyEntity haveMoney() {
		String sql = "SELECT * FROM vendingmachine.money;";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql);
		
		MoneyEntity haveMoney = new MoneyEntity();
		
		haveMoney.setThousand((int)result.get("thousand"));
		haveMoney.setFiveHundred((int)result.get("fiveHundred"));
		haveMoney.setOneHundred((int)result.get("oneHundred"));
		haveMoney.setFifty((int)result.get("fifty"));
		haveMoney.setTen((int)result.get("ten"));
		return haveMoney;
	}

}
