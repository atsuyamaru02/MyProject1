package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BuyEntity;

@Repository
public class ChangeDaoImpl implements ChangeDao {
	
	private final JdbcTemplate jdbcTemplate;

	public ChangeDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int update(BuyEntity buy) {
		
		return jdbcTemplate.update("UPDATE vendingmachine.drink_menu_list SET name = ?, image = ?, price = ?, hotcold = ?, stock = ?, quantity = ? WHERE id = ?",
				buy.getName(), buy.getImage(), buy.getPrice(), buy.getHotcold(), buy.getStock(), buy.getQuantity(),buy.getId());
	}

}
