package com.housebooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.housebooking.app.model.HouseBookingModel;
import com.housebooking.app.service.HouseBookingService;

@Controller
public class HouseBookingController {
	
	@Autowired
	private HouseBookingService housebookingservice;
	
	@GetMapping("/")
	public String getHome(Model model)
	{
		return "home";
	}
	
	@GetMapping("/register")
	public String getRegister(Model model)
	{
		HouseBookingModel hbmodel = new HouseBookingModel();
		model.addAttribute("housebooking", hbmodel);
		return "housebookingViews/register";
	}
	@PostMapping("/savehousebooking")
	public String saveHouseBooking(@ModelAttribute("housebooking") HouseBookingModel housebooking)
	{
		housebookingservice.savehousebooking(housebooking);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String getLoginPage(Model model)
	{
		HouseBookingModel hbmodel = new HouseBookingModel();
		model.addAttribute("housebooking", hbmodel);
		return "housebookingViews/login";
	}
	
	@PostMapping("/loginHouseBooking")
	public String loginNewHire(@ModelAttribute("hbmodel") HouseBookingModel hbmodel, Model model)
	{
		int  output=housebookingservice.authenticateHouseBooking(hbmodel);
		
		if(output == 1)
		{
			model.addAttribute("username","Welcome to HouseBooking"+hbmodel.getEmail().split("@")[0].toString());
			return "housebookingViews/welcome";
		}
		else {
			model.addAttribute("errormsg", "Invalid Login Credentials");
			return "housebookingViews/error";
		}
		
		
	}


}
