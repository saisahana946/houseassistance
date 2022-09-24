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
public class UserController {
	
	@Autowired
	private HomeService userloginservice;
	
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
		UserModel  userModel = userloginservice.authenticateUser(user);
		String username="";
		System.out.println("output=== "+userModel);
		if(userModel != null)
		{
			if(userModel.getUsertype().equals("houseowner")) {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Welcome to Temporary housing Assistance Dashboard"+" "+username);
				return "housebookingViews/welcomehouseowner";
			} 
			else if(userModel.getUsertype().equals("student")) {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Welcome to Temporary housing Assistance Dashboard"+" "+username);
				return "housebookingViews/welcomestudent";
			}
			else {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Hi,"+" "+username+"Welcome to Temporary housing Assistance ADMIN Dashboard");
				return "housebookingViews/welcomeadmin";
			}
		}
		else {
			model.addAttribute("errormsg", "Invalid Login Credentials. Please try again.");
			return "housebookingViews/error";
		}
		
		
	}

}
