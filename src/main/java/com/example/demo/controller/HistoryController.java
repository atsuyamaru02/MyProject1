package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.HistoryEntity;
import com.example.demo.service.HistoryService;

@Controller
@RequestMapping("/admin")
public class HistoryController {
	private final HistoryService historyService;
	
	public HistoryController(HistoryService historyService) {
		this.historyService = historyService;
	}

	//購入履歴
	@GetMapping("/history")
	public String history(Model model) {
		List<HistoryEntity> list = historyService.getAll();
		model.addAttribute("historyList",list);
		
		return "admin/history";
	}
}
