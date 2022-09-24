package com.housebooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.housebooking.app.model.UserModel;
import com.housebooking.app.service.UserRegistrationService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserRegistrationService userregistrationservice;
	
	@GetMapping("/userregister")
	public String getRegister(Model model)
	{
		System.out.println("hiii");
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "user/userRegistration";
	}
	
	@PostMapping("/saveuser")
	public String saveHouseBooking(@ModelAttribute("user") UserModel user)
	{
		System.out.println("save===user");
		userregistrationservice.saveuser(user);
		return "user/userLogin";
	}
}
