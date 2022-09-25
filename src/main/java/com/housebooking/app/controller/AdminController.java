package com.housebooking.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.housebooking.app.model.UserModel;

@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String getAdminWelcomePage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "admin/welcomeadmin";
	}

	
}
