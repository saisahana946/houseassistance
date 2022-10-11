package com.housebooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.housebooking.app.model.Announcement;
import com.housebooking.app.model.Notification;
import com.housebooking.app.model.UserModel;
import com.housebooking.app.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin")
	public String getAdminWelcomePage(Model model)
	{
		UserModel usermodel = new UserModel();
		model.addAttribute("user", usermodel);
		return "admin/welcomeadmin";
	}
	
	@GetMapping("/notification")
	public String getNotificationPage(Model model) {
		
		Notification notification = new Notification();
		
		model.addAttribute("notification", notification);
		return "admin/addnotification";
		
	}
	
	@PostMapping("/postNotification")
	public String postNotification(@ModelAttribute("notification") Notification notification) {
		
		adminService.addNotification(notification);
		
		return "redirect:/admin";
		
	}
	
	@GetMapping("/announcement")
	public String getAnnouncementPage(Model model) {
		
		Announcement announcement = new Announcement();
		
		model.addAttribute("announcement", announcement);
		return "admin/addannouncement";
		
	}
	
	@PostMapping("/postAnnouncement")
	public String postNotification(@ModelAttribute("announcement") Announcement announcement) {
		
		adminService.addAnnouncement(announcement);
		
		return "redirect:/admin";
		
	}
	
}
