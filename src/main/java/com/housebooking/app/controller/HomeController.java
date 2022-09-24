package com.housebooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.housebooking.app.model.UserModel;
import com.housebooking.app.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/")
	public String getHome(Model model)
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String getRegister(Model model)
	{
		
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "home/register";
	}
	
	@PostMapping("/saveUser")
	public String saveHouseBooking(@ModelAttribute("user") UserModel user)
	{
		System.out.println("save===user");
		homeService.saveUser(user);
		return "home/login";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "home/login";
	}
	
	@PostMapping("/authenticateLogin")
	public String loginUser(@ModelAttribute("user") UserModel user, Model model)
	{
		System.out.println("login**************************************** ");
		UserModel  userModel = homeService.authenticateUser(user);
		String username="";
		System.out.println("output=== "+userModel);
		if(userModel != null)
		{
			if(userModel.getUsertype().equals("houseowner")) {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Welcome to Temporary housing Assistance Dashboard"+" "+username);
				return "houseowner/welcomehouseowner";
			} 
			else if(userModel.getUsertype().equals("student")) {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Welcome to Temporary housing Assistance Dashboard"+" "+username);
				return "user/welcomeuser";
			}
			else {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Hi,"+" "+username+"Welcome to Temporary housing Assistance ADMIN Dashboard");
				return "admin/welcomeadmin";
			}
		}
		else {
			model.addAttribute("errormsg", "Invalid Login Credentials. Please try again.");
			return "home/error";
		}
		
		
	}


}
