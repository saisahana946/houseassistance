package com.housebooking.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.housebooking.app.model.UserModel;

@Controller
public class HouseOwnerController {
	@GetMapping("/houseowner")
	public String getHouseOwnerWelcomePage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "houseowner/welcomehouseowner";
	}
}
