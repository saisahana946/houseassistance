package com.housebooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.housebooking.app.model.UserModel;
import com.housebooking.app.service.UserLoginService;


@Controller
public class UserLoginController {
	
	@Autowired
	private UserLoginService userloginservice;
	
	@GetMapping("/userlogin")
	public String getLoginPage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "user/userLogin";
	}
	
	@PostMapping("/authenticateuserlogin")
	public String loginUser(@ModelAttribute("user") UserModel user, Model model)
	{
		System.out.println("login**************************************** ");
		int  output=userloginservice.authenticateUser(user);
		String username="";
		System.out.println("output=== "+output);
		if(output == 1)
		{
			username=user.getEmail().split("@")[0].toString().toUpperCase();
			model.addAttribute("username","Welcome to Temporary housing Assistance Dashboard"+" "+username);
			return "housebookingViews/welcome";
		}
		else {
			model.addAttribute("errormsg", "Invalid Login Credentials. Please try again.");
			return "housebookingViews/error";
		}
		
		
	}

}
