package com.example.demo.auth;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		userRepository.findByUsername(username)
			.map(user -> new CustomUserDetails(user.getUsername(),user.getPassword(),Collections.emptyList()))
			.orElseThrow(() -> new UsernameNotFoundException(username + "が見つかりません"));
		
		return new CustomUserDetails("tom","password",Collections.emptyList());
		// TODO 自動生成されたメソッド・スタブ
	//	throw new UsernameNotFoundException(username + "が見つかりません");
	}

}
