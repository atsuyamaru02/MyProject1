package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.entity.User.Authority;

@Repository
public class UserInfoDaoImpl  implements UserInfoDao{

	private final JdbcTemplate jdbcTemplate;
	public UserInfoDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// ユーザー追加処理
	@Override
	public void insertUser(User user) {
		jdbcTemplate.update("INSERT INTO users(username, password, authority) VALUES(?, ?, ?)",
				user.getUsername(),user.getPassword(),user.getAuthority().toString());
	}

	// ユーザー取得
	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM users";
		List<Map<String, Object>> userList = jdbcTemplate.queryForList(sql);
		List<User> list = new ArrayList<User>();
		for(Map<String, Object> result : userList) {
			User user = new User((String)result.get("username"),(String)result.get("password"),(Authority)result.get("authority"));
			list.add(user);
		}
		return list;
	}

}
