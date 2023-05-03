package com.example.demo.auth;

import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		return userRepository.findByUsername(username)
			.map(user -> new CustomUserDetails(user.getUsername(),user.getPassword(),toGurantedAuthorityList(user.getAuthority().toString())))
			.orElseThrow(() -> new UsernameNotFoundException(username + "が見つかりません"));
	}
	
	private List<GrantedAuthority> toGurantedAuthorityList(String authority){
		return Collections.singletonList(new SimpleGrantedAuthority(authority));
	}
}
