package com.example.demo.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.BuyEntity;
import com.example.demo.entity.HistoryEntity;
import com.example.demo.entity.MoneyEntity;
import com.example.demo.form.MoneyForm;
import com.example.demo.form.PurchaseForm;
import com.example.demo.service.BuyService;
import com.example.demo.service.MoneyService;

@Controller
@RequestMapping("/user")
public class BuyController {
	
	private final BuyService buyService;
	private final MoneyService moneyService;
	
	public BuyController(BuyService buyService,MoneyService moneyService) {
		this.buyService = buyService;
		this.moneyService = moneyService;
	}
	
	//購入画面へのアクセス
	@GetMapping("/buy")
	public String buy(Model model) {
//		List<BuyEntity> list = buyService.getAll();
		BuyEntity buy1 = buyService.getById(1);
		BuyEntity buy2 = buyService.getById(2);
		BuyEntity buy3 = buyService.getById(3);
		BuyEntity buy4 = buyService.getById(4);
//		model.addAttribute("buyList",list);
		MoneyForm moneyForm = new MoneyForm();
		
		model.addAttribute("drink1", buy1);
		model.addAttribute("drink2", buy2);
		model.addAttribute("drink3", buy3);
		model.addAttribute("drink4", buy4);
		model.addAttribute("moneyForm", moneyForm);
		
		int totalInsert = 0;
		model.addAttribute("totalInsert", totalInsert);
		
		MoneyEntity money = new MoneyEntity();
		money.setThousand(0);
		money.setFiveHundred(0);
		money.setOneHundred(0);
		money.setFifty(0);
		money.setTen(0);
		model.addAttribute("money", money);
		
		boolean moneyFlg = moneyService.stock();
		model.addAttribute("moneyFlg", moneyFlg);
		
		return "user/buy";
	}
	
	//商品購入処理
	@PostMapping("/purchase")
	public String purchase(PurchaseForm purchaseForm, MoneyForm moneyForm, RedirectAttributes redirectAttributes,int totalInsert) {
		HistoryEntity history = new HistoryEntity();
		history.setName(purchaseForm.getName());
		history.setPrice(purchaseForm.getPrice());
		history.setHotcold(purchaseForm.getHotcold());
		history.setQuantity(purchaseForm.getQuantity());
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		history.setBuydatetime(sdf.format(today));
		
		MoneyEntity money1 = new MoneyEntity();
		money1.setThousand(moneyForm.getThousand());
		money1.setFiveHundred(moneyForm.getFiveHundred());
		money1.setOneHundred(moneyForm.getOneHundred());
		money1.setFifty(moneyForm.getFifty());
		money1.setTen(moneyForm.getTen());
		
		moneyService.increase(money1);
		
		buyService.sava(history);
		buyService.reduceOne(purchaseForm.getId());
		
		int change = totalInsert - purchaseForm.getPrice();
		String changeComment = null;
		if(0 < change) {
			changeComment = "お釣りは" + change + "円です。";
		}
		
		redirectAttributes.addFlashAttribute("complete", purchaseForm.getName() + "を購入しました。");
		redirectAttributes.addFlashAttribute("change", changeComment);
		
		MoneyEntity money2 = new MoneyEntity();
		money2.setThousand(change/1000);
		change = change%1000;
		money2.setFiveHundred(change/500);
		change = change%500;
		money2.setOneHundred(change/100);
		change = change%100;
		money2.setFifty(change/50);
		change = change%50;
		money2.setTen(change/10);
		
		moneyService.reduce(money2);
		
		
		
		
		return "redirect:/user/buy";
	}
	
	@PostMapping("/money")
	public String change(Model model,@Validated MoneyForm moneyForm,BindingResult result){
		model.addAttribute("moneyForm", moneyForm);
		BuyEntity buy1 = buyService.getById(1);
		BuyEntity buy2 = buyService.getById(2);
		BuyEntity buy3 = buyService.getById(3);
		BuyEntity buy4 = buyService.getById(4);
		model.addAttribute("drink1", buy1);
		model.addAttribute("drink2", buy2);
		model.addAttribute("drink3", buy3);
		model.addAttribute("drink4", buy4);
		
		int totalInsert = 1000*moneyForm.getThousand() + 500*moneyForm.getFiveHundred() + 100*moneyForm.getOneHundred()
							+ 50*moneyForm.getFifty() + 10*moneyForm.getTen();
		
		model.addAttribute("totalInsert", totalInsert);
		
		MoneyEntity money = new MoneyEntity();
		money.setThousand(moneyForm.getThousand());
		money.setFiveHundred(moneyForm.getFiveHundred());
		money.setOneHundred(moneyForm.getOneHundred());
		money.setFifty(moneyForm.getFifty());
		money.setTen(moneyForm.getTen());
		model.addAttribute("money", money);
		
		boolean moneyFlg = moneyService.stock();
		model.addAttribute("moneyFlg", moneyFlg);
		
		if(result.hasErrors()) {
			return "user/buy";
		}
		return "user/buy";
	}

}
