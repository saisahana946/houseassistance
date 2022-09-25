package com.housebooking.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.housebooking.app.model.UserModel;



@Controller
public class UserController {
	@GetMapping("/user")
	public String getHouseOwnerWelcomePage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "user/welcomeuser";
	}
}
