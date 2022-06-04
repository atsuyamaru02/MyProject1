package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.BuyEntity;
import com.example.demo.form.ChangeForm;
import com.example.demo.service.ChangeService;

@Controller
@RequestMapping("/admin")
public class ChangeController {
	
	private final ChangeService changeService;
	
	public ChangeController(ChangeService changeService) {
		this.changeService = changeService;
	}
	
	//商品変更フォームへのアクセス
	@GetMapping("/change")
	public String change(Model model) {
		ChangeForm changeForm = new ChangeForm();
		model.addAttribute("changeForm", changeForm);
		
		return "admin/change";
	}
	
	//商品変更フォーム変更ボタン押下
	@PostMapping("/confirm")
	public String confirm(Model model,@Validated ChangeForm changeForm,BindingResult result){
		model.addAttribute("changeForm", changeForm);
		if(result.hasErrors()) {
			return "admin/change";
		}
		return "admin/confirm";
	}
	
	//変更内容確認画面で戻るボタンを押す際に入力値を戻す
	@PostMapping("/change")
	public String change(Model model,@Validated ChangeForm changeForm,BindingResult result){
		model.addAttribute("changeForm", changeForm);
		if(result.hasErrors()) {
			return "admin/confirm";
		}
		return "admin/change";
	}
	
	//変更内容確認画面
	@GetMapping("/confirm")
	public String changeConfirm(ChangeForm changeForm,Model model) {
		model.addAttribute("title", "Inquiry Form");
		return "admin/confirm";
	}
	
	//changeFormのデータをBuyEntityに詰める
	private BuyEntity makeBuy(ChangeForm changeForm) {
		BuyEntity buy = new BuyEntity();
		
		buy.setId(changeForm.getId());
		buy.setName(changeForm.getName());
		buy.setImage(changeForm.getImage());
		buy.setPrice(changeForm.getPrice());
		buy.setHotcold(changeForm.getHotcold());
		buy.setStock(changeForm.getStock());
		buy.setQuantity(changeForm.getQuantity());
		
		return buy;
	}
	
	@PostMapping("/complete")
	public String complete(Model model,@Validated ChangeForm changeForm,BindingResult result){
		model.addAttribute("changeForm", changeForm);
		if(result.hasErrors()) {
			return "admin/confirm";
		}
		
		BuyEntity buy = new BuyEntity();
		
		buy = makeBuy(changeForm);
		changeService.update(buy);
		
		return "redirect:/admin/change";
	}
}
