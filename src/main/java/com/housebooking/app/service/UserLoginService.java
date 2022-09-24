package com.housebooking.app.service;
import java.util.List;
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
	
	public int authenticateUser(UserModel usermodel) {
		List<UserModel> user = userrepo.findAll();
		long c= 0;
		c = user.stream().filter(n -> n.getEmail().equals(usermodel.getEmail()) && n.getPassword().equals(usermodel.getPassword())).count();
		
		System.out.println(c);
		
		if(c == 1)
		{
			return 1;
		}else
		{
			return 0;
		}
	}
}
