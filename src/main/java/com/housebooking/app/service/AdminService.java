package com.housebooking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housebooking.app.dao.AnnouncementRepo;
import com.housebooking.app.dao.NotificationRepo;
import com.housebooking.app.model.Announcement;
import com.housebooking.app.model.Notification;

@Service
public class AdminService {
	
	@Autowired
	private NotificationRepo notificationRepo;
	
	@Autowired
	private AnnouncementRepo announcementRepo;
	
	public String addNotification(Notification notification) {
		
		notificationRepo.save(notification);
		return "Notification Saved Successfully";
	}
	
	public String addAnnouncement(Announcement announcement) {
		
		announcementRepo.save(announcement);
		return "Announcement Saved Successfully";
	}

}
