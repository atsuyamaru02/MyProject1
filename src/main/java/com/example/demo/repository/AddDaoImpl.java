package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BuyEntity;

@Repository
public class AddDaoImpl implements AddDao {
	
	private final JdbcTemplate jdbcTemplate;

	public AddDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int update(BuyEntity buy) {
		return jdbcTemplate.update("UPDATE vendingmachine.drink_menu_list SET stock = ? WHERE id = ?",buy.getStock(),buy.getId());
	}

}
