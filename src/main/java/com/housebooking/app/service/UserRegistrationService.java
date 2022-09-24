package com.housebooking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.housebooking.app.dao.UserRegistrationRepo;
import com.housebooking.app.model.UserModel;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRegistrationRepo userrepo;

	public void saveuser(UserModel user) {
		System.out.println("save===user===service");
		userrepo.save(user);
		
	}
}
