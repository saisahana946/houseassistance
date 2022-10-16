package com.housebooking.app.service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housebooking.app.dao.HouseRepo;
import com.housebooking.app.model.HouseModel;

@Service
public class HouseOwnerService {
	
	@Autowired
	private HouseRepo houseRepo;

	public void saveHouse(HouseModel house) {
		
		houseRepo.save(house);
		
		
	}

	public HouseModel getHouse() {
		// TODO Auto-generated method stub
		return houseRepo.findAll().get(0);
	}

	public List<HouseModel> getAllHousesByEmail(String emailId) {
		// TODO Auto-generated method stub
		List<HouseModel> houses = houseRepo.findAllByEmailId(emailId);
		
//		houses.forEach(house -> house.setHouseImage(Base64.getEncoder().encodeToString(house.getHousePhoto())));
		return houses;
	}

}
