package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.MoneyEntity;
import com.example.demo.form.MoneyForm2;
import com.example.demo.service.MoneyService;

@Controller
@RequestMapping("/admin")
public class MoneyController {
	
	private final MoneyService moneyService;
	
	public MoneyController(MoneyService moneyService) {
		this.moneyService = moneyService;
	}
	
	// 紙幣・貨幣状況画面へのアクセス
	@PreAuthorize("hasAuthority('INFOADMIN') OR hasAuthority('MONEY')")
	@GetMapping("/money_stock")
	public String moneyStock(Model model) {
		MoneyEntity haveMoney = moneyService.haveMoney();
		model.addAttribute("money", haveMoney);
		
		return "admin/money_stock";
	}
	
	// 紙幣・貨幣追加フォーム画面へのアクセス
	@PreAuthorize("hasAuthority('MONEY')")
	@GetMapping("/money_add")
	public String moneyAdd(Model model) {
		MoneyEntity haveMoney = moneyService.haveMoney();
		MoneyForm2 moneyForm = new MoneyForm2();
		
		model.addAttribute("money", haveMoney);
		model.addAttribute("moneyForm", moneyForm);
		
		return "admin/money_add";
	}
	
	// 紙幣・貨幣追加処理
	@PostMapping("/money_add")
	public String moneyAdd(Model model,MoneyForm2 moneyForm, RedirectAttributes redirectAttributes){
		model.addAttribute("moneyForm", moneyForm);
		
		String errmsg1000 = null;
		String errmsg500 = null;
		String errmsg100 = null;
		String errmsg50 = null;
		String errmsg10 = null;
		
		if(moneyForm.getThousand() < 0) {
			errmsg1000 = "1000円札は0枚以上を選択してください";
			model.addAttribute("errmsg1000", errmsg1000);
		}
		
		if(moneyForm.getFiveHundred() < 0) {
			errmsg500 = "500円玉は0枚以上を選択してください";
			model.addAttribute("errmsg500", errmsg500);
		}
		
		if(moneyForm.getOneHundred() < 0) {
			errmsg100 = "100円玉は0枚以上を選択してください";
			model.addAttribute("errmsg100", errmsg100);
		}
		
		if(moneyForm.getFifty() < 0) {
			errmsg50 = "50円玉は0枚以上を選択してください";
			model.addAttribute("errmsg50", errmsg50);
		}
		
		if(moneyForm.getTen() < 0) {
			errmsg10 = "10円玉は0枚以上を選択してください";
			model.addAttribute("errmsg10", errmsg10);
		}

		
		if((errmsg1000 != null) || (errmsg500 != null) || (errmsg100 != null) || (errmsg50 != null) || (errmsg10 != null)){
			MoneyEntity haveMoney = moneyService.haveMoney();
			model.addAttribute("money", haveMoney);
			return "admin/money_add";
		}
		
		if((moneyForm.getThousand() == 0) && (moneyForm.getFiveHundred() == 0) && (moneyForm.getOneHundred() == 0) 
			&& (moneyForm.getFifty() == 0) && (moneyForm.getTen() == 0)) {
			MoneyEntity haveMoney = moneyService.haveMoney();
			model.addAttribute("money", haveMoney);
			return "admin/money_add";
		}
		
		MoneyEntity money = new MoneyEntity();
		money.setThousand(moneyForm.getThousand());
		money.setFiveHundred(moneyForm.getFiveHundred());
		money.setOneHundred(moneyForm.getOneHundred());
		money.setFifty(moneyForm.getFifty());
		money.setTen(moneyForm.getTen());
		
		moneyService.increase(money);
		redirectAttributes.addFlashAttribute("complete", "追加が完了しました。");
		
		return "redirect:/admin/money_add";
	}
	
	// 紙幣・貨幣回収フォーム画面へのアクセス
	@PreAuthorize("hasAuthority('MONEY')")
	@GetMapping("/money_collect")
	public String moneyCollect(Model model) {
		MoneyEntity haveMoney = moneyService.haveMoney();
		MoneyForm2 moneyForm = new MoneyForm2();
		
		model.addAttribute("money", haveMoney);
		model.addAttribute("moneyForm", moneyForm);
		
		return "admin/money_collect";
	}
	
	// 紙幣・貨幣回収処理
	@PostMapping("/money_collect")
	public String moneyCollect(Model model,MoneyForm2 moneyForm, RedirectAttributes redirectAttributes){
		model.addAttribute("moneyForm", moneyForm);
				
		String errmsg1000 = null;
		String errmsg500 = null;
		String errmsg100 = null;
		String errmsg50 = null;
		String errmsg10 = null;
		
		if(moneyForm.getThousand() < 0) {
			errmsg1000 = "1000円札は0枚以上を選択してください";
			model.addAttribute("errmsg1000", errmsg1000);
		}
		
		if(moneyForm.getFiveHundred() < 0) {
			errmsg500 = "500円玉は0枚以上を選択してください";
			model.addAttribute("errmsg500", errmsg500);
		}
		
		if(moneyForm.getOneHundred() < 0) {
			errmsg100 = "100円玉は0枚以上を選択してください";
			model.addAttribute("errmsg100", errmsg100);
		}
		
		if(moneyForm.getFifty() < 0) {
			errmsg50 = "50円玉は0枚以上を選択してください";
			model.addAttribute("errmsg50", errmsg50);
		}
		
		if(moneyForm.getTen() < 0) {
			errmsg10 = "10円玉は0枚以上を選択してください";
			model.addAttribute("errmsg10", errmsg10);
		}

		
		if((errmsg1000 != null) || (errmsg500 != null) || (errmsg100 != null) || (errmsg50 != null) || (errmsg10 != null)){
			MoneyEntity haveMoney = moneyService.haveMoney();
			model.addAttribute("money", haveMoney);
			return "admin/money_collect";
		}
		
		if((moneyForm.getThousand() == 0) && (moneyForm.getFiveHundred() == 0) && (moneyForm.getOneHundred() == 0) 
			&& (moneyForm.getFifty() == 0) && (moneyForm.getTen() == 0)) {
			MoneyEntity haveMoney = moneyService.haveMoney();
			model.addAttribute("money", haveMoney);
			return "admin/money_add";
		}
		
		MoneyEntity money = new MoneyEntity();
		money.setThousand(moneyForm.getThousand());
		money.setFiveHundred(moneyForm.getFiveHundred());
		money.setOneHundred(moneyForm.getOneHundred());
		money.setFifty(moneyForm.getFifty());
		money.setTen(moneyForm.getTen());
		
		moneyService.reduce(money);
		redirectAttributes.addFlashAttribute("complete", "回収が完了しました。");
		
		return "redirect:/admin/money_collect";
	}
}
