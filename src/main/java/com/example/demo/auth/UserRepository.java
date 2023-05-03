package com.example.demo.auth;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

@Mapper
public interface UserRepository {
	
	@Select("select * from users where username = #{username}")
	Optional<User> findByUsername(String username);
	
	@Select("select * from users")
	List<User> findAll();
}
