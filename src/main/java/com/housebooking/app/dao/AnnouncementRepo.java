package com.housebooking.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.housebooking.app.model.Announcement;

public interface AnnouncementRepo extends JpaRepository<Announcement, Long>{

}
