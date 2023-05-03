package com.example.demo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.BuyEntity;
import com.example.demo.service.BuyService;

@Controller
@RequestMapping("/admin")
public class DrinkContoller {
	
	private final BuyService buyService;
	
	public DrinkContoller(BuyService buyService) {
		this.buyService = buyService;
	}
	
	//ドリンク情報画面へのアクセス
	@PreAuthorize("hasAuthority('INFOADMIN') OR hasAuthority('DRINK')")
	@GetMapping("/drink_information")
	public String buy(Model model) {
		List<BuyEntity> drinks = buyService.getAll();
	model.addAttribute("drinkList", drinks);
		
	return "admin/drink_information";
	}
}
