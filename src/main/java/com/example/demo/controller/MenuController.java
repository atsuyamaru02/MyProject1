package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MenuController {
	// メニュー画面へのアクセス
	@GetMapping("/menu")
	public String menu() {
		return "admin/menu";
	}
}
