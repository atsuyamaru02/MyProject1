package com.example.demo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.service.UserInfoService;

@Controller
@RequestMapping("/admin")
public class UserController {
	
	private final UserInfoService userInfoService;
	
	public UserController(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	// ユーザー作成画面へのアクセス
	@PreAuthorize("hasAuthority('INFOADMIN')")
	@GetMapping("/user_add")
	public String add(Model model) {
		UserForm userForm = new UserForm();
		model.addAttribute("userForm",userForm);
		return "admin/user_add";
	}
	
	// ユーザー作成処理
	@PostMapping("/user_add")
	public String confirm(Model model,@Validated UserForm userForm,BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()) {
			return "admin/user_add";
		}
		
		User user = new User(userForm.getUsername(),userForm.getPassword(),userForm.getAuthority());
		
		userInfoService.addUser(user);
		
		redirectAttributes.addFlashAttribute("complete", "ユーザー(" + user.getUsername() + ")を追加しました。");
		return "redirect:/admin/user_add";
	}
	
	// ユーザー一覧画面へのアクセス
	@PreAuthorize("hasAuthority('INFOADMIN')")
	@GetMapping("/user_list")
	public String list(Model model) {
		List<User> list = userInfoService.findAll();
		model.addAttribute("userList",list);
		return "admin/user_list";
	}
}
