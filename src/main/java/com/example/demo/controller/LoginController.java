package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginController {
	//ログイン画面へのアクセス
	@GetMapping("/login")
	public String showLogin() {
		return "user/login";
	}
}
