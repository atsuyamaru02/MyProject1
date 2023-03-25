package com.example.demo.auth;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

//@Repository
@Mapper
public interface UserRepository {
	
//	@Query(value = queryfindByUsername, nativeQuery = true)
	@Select("select * from user where username = #{username}")
	Optional<User> findByUsername(String username);
	
	//public static final String queryfindByUsername = "select * from user where username = :username";
	
	

}
