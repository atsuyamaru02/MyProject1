package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.HistoryEntity;

@Repository
public class HistoryDaoImpl implements HistoryDao {

private final JdbcTemplate jdbcTemplate;
	
	public HistoryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	@Override
//	public void insertHistory(History history) {
//		jdbcTemplate.update("INSERT INTO purchase_history(name, price, hotcold, quantity, buydatetime) VALUES(?, ?, ?, ?, ?)",
//				history.getName(), history.getPrice(), history.getHotcold(), history.getQuantity(), history.getBuydatetime() );
//
//	}

	@Override
	public List<HistoryEntity> getAll() {
		String sql = "SELECT * FROM purchase_history";
		List<Map<String, Object>> purchaseHistoryList = jdbcTemplate.queryForList(sql);
		List<HistoryEntity> list = new ArrayList<HistoryEntity>();
		for(Map<String, Object> result : purchaseHistoryList) {
			HistoryEntity history = new HistoryEntity();
			history.setName((String)result.get("name"));
			history.setPrice((int)result.get("price"));
			history.setHotcold((String)result.get("hotcold"));
			history.setQuantity((int)result.get("quantity"));
//			history.setBuydatetime(((Timestamp)result.get("buydatetime")).toLocalDateTime());
			history.setBuydatetime(((String)result.get("buydatetime")));
			list.add(history);
		}
		return list;
	}

}
