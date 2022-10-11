package com.housebooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.housebooking.app.model.EmailModel;
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
		return "redirect:/login";
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
				return "redirect:/houseowner";
			} 
			else if(userModel.getUsertype().equals("student")) {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Welcome to Temporary housing Assistance Dashboard"+" "+username);
				return "redirect:/user";
			}
			else {
				username=userModel.getEmail().split("@")[0].toString().toUpperCase();
				model.addAttribute("username","Hi,"+" "+username+"Welcome to Temporary housing Assistance ADMIN Dashboard");
				return "redirect:/admin";
			}
		}
		else {
			model.addAttribute("errormsg", "Invalid Login Credentials. Please try again.");
			return "home/error";
		}
		
		
	}
	
	@GetMapping("/forgotUsername")
	public String getForgotUsernamePage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "home/forgotusername";
	}
	
	@GetMapping("/forgotPassword")
	public String getForgotPasswordPage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "home/forgotpassword";
	}
	
	
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute("user") UserModel user, Model model)
	{	
		int output = 0;
		System.out.println("save===usernew password");
		System.out.println("userModel#########"+user.toString());
		UserModel userModel=homeService.findUser(user.getEmail());
		EmailModel emailmodel = new EmailModel();
		emailmodel.setMsgBody("Your Username is"+ userModel.getFirstname()+" "+userModel.getLastname());
		emailmodel.setRecipient(userModel.getEmail());
		emailmodel.setSubject("Username Recovery from HouseAssistance");
		System.out.println("------------------body"+ emailmodel.getMsgBody()+"======="+ emailmodel.getRecipient());
		output = homeService.sendSimpleMail(emailmodel);
		
		System.out.println("------------------"+ output);
		if(output !=1) {
			model.addAttribute("errmsg", "Email address does not exist.");
		}
		return "redirect:/login";
	}
	
	@PostMapping("/validateForgotPassword")
	public String validatePassword(@ModelAttribute("user") UserModel user, Model model,RedirectAttributes redirectAttrs)
	{
		System.out.println("forgot password**************************************** ");
		String email="";
		UserModel  userModel = homeService.validatePassword(user);
		System.out.println("output=== "+userModel);
		if(userModel != null)
		{
			email=userModel.getEmail();
			System.out.println("email ***** "+email);
			System.out.println(userModel);
//			UserModel usermodel = new UserModel();
			model.addAttribute("user", userModel);
			model.addAttribute("email",email);
//			redirectAttrs.addFlashAttribute("email", email);
//			return "redirect:/changePassword";
			return "home/changepassword";
		}
		else {
			model.addAttribute("errormsg", "Invalid Login Credentials. Please try again.");
			return "home/error";
		}
		
		
	}
	
	@GetMapping("/changePassword")
	public String getChangePasswordPage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "home/changepassword";
	}
	
	@PostMapping("/saveNewPassword")
	public String saveNewPassword(@ModelAttribute("user") UserModel user)
	{
		System.out.println("save===usernew password");
		System.out.println("userModel#########"+user.toString());
		homeService.saveNewPassword(user);
		return "redirect:/login";
	}


}
