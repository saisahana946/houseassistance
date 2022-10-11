package com.housebooking.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housebooking.app.model.Notification;
import com.housebooking.app.model.UserModel;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {

}
