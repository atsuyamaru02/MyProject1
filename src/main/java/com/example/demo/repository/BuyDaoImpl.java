package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BuyEntity;
import com.example.demo.entity.HistoryEntity;


@Repository
public class BuyDaoImpl implements BuyDao {
	
	private final JdbcTemplate jdbcTemplate;
	public BuyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<BuyEntity> getAll() {
		String sql = "SELECT * FROM drink_menu_list";
		List<Map<String, Object>> drinkMenuList = jdbcTemplate.queryForList(sql);
		List<BuyEntity> list = new ArrayList<BuyEntity>();
		for(Map<String, Object> result : drinkMenuList) {
			BuyEntity buy = new BuyEntity();
			buy.setId((int)result.get("id"));
			buy.setName((String)result.get("name"));
			buy.setImage((String)result.get("image"));
			buy.setPrice((int)result.get("price"));
			buy.setHotcold((String)result.get("hotcold"));
			buy.setStock((int)result.get("stock"));
			buy.setQuantity((int)result.get("quantity"));
			list.add(buy);
		}
		return list;
	}

	@Override
	public BuyEntity getById(int id) {
		String sql = "SELECT * FROM vendingmachine.drink_menu_list WHERE id = ?;";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);
		
		BuyEntity buy = new BuyEntity();
		buy.setId((int)result.get("id"));
		buy.setName((String)result.get("name"));
		buy.setImage((String)result.get("image"));
		buy.setPrice((int)result.get("price"));
		buy.setHotcold((String)result.get("hotcold"));
		buy.setStock((int)result.get("stock"));
		buy.setQuantity((int)result.get("quantity"));
		return buy;
	}

	@Override
	public void insertHistory(HistoryEntity history) {
		jdbcTemplate.update("INSERT INTO purchase_history(name, price, hotcold, quantity, buydatetime) VALUES(?, ?, ?, ?, ?)",
				history.getName(), history.getPrice(), history.getHotcold(), history.getQuantity(), history.getBuydatetime() );

	}

	@Override
	public void reduceOne(int id) {
		String sql = "SELECT * FROM vendingmachine.drink_menu_list WHERE id = ?;";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);
		
		BuyEntity buy = new BuyEntity();
		buy.setStock((int)result.get("stock"));
		
		jdbcTemplate.update("UPDATE drink_menu_list SET stock = ? WHERE id = ?",
				buy.getStock()-1, id);
		
	}
}
