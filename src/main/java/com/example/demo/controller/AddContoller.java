package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.BuyEntity;
import com.example.demo.form.AddForm;
import com.example.demo.service.AddService;
import com.example.demo.service.BuyService;

@Controller
@RequestMapping("/admin")
public class AddContoller {
	
	private final AddService addService;
	private final BuyService buyService;
	
	public AddContoller(AddService addService, BuyService buyService) {
		this.addService = addService;
		this.buyService = buyService;
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		AddForm addForm = new AddForm();
		model.addAttribute("addForm",addForm);
		return "admin/add";
	}
	
	@PostMapping("/add")
	public String confirm(Model model,@Validated AddForm addForm,BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/add";
		}
		
		BuyEntity buy = new BuyEntity();
		buy.setId(addForm.getId());
		buy.setStock(addForm.getStock());
		
		addService.update(buy);
		
		BuyEntity drink = buyService.getById(addForm.getId());
		
		redirectAttributes.addFlashAttribute("complete", drink.getName() + "を" + addForm.getStock() + "個追加しました。");
		return "redirect:/admin/add";
	}
	
	@PostMapping("/getDrinkName")
	public Map<Integer, String> getDrinkName(AddForm addForm){
		Map<Integer, String> result = new LinkedHashMap<Integer, String>();
		BuyEntity buy = buyService.getById(addForm.getId());
		if(buy != null) {
			result.put(buy.getId(), buy.getName());
		}else {
			result.put(null, null);
		}
		return result;
	}
}
