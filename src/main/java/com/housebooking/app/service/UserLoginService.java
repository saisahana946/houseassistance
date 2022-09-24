package com.housebooking.app.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.housebooking.app.dao.UserLoginRepo;
import com.housebooking.app.model.UserModel;

@Service
public class UserLoginService {
	
	@Autowired
	private UserLoginRepo userrepo;
	public void saveuser(UserModel user) {
		userrepo.save(user);
		
	}
	
	public UserModel authenticateUser(UserModel usermodel) {
		List<UserModel> user = userrepo.findAll();
		List<UserModel> veifiedUser = user.stream().filter(n -> n.getEmail().equals(usermodel.getEmail()) && n.getPassword().equals(usermodel.getPassword())).collect(Collectors.toList());
		
		System.out.println(veifiedUser.get(0));
		
		return veifiedUser.get(0);
		
	}
}
