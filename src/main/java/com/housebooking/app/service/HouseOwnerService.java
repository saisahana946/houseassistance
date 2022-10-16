package com.housebooking.app.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housebooking.app.dao.HouseRepo;
import com.housebooking.app.dao.ReportRepo;
import com.housebooking.app.dao.ReviewRepo;
import com.housebooking.app.model.HouseModel;
import com.housebooking.app.model.ReportModel;
import com.housebooking.app.model.ReviewModel;

@Service
public class HouseOwnerService {
	
	@Autowired
	private HouseRepo houseRepo;
	
	@Autowired
	private ReportRepo reportRepo;
	
	@Autowired
	private ReviewRepo reviewRepo;

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

	public void deleteHouse(Long id) {
		// TODO Auto-generated method stub
		houseRepo.deleteById(id);
	}

	public HouseModel getHouseById(Long id) {
		// TODO Auto-generated method stub
		
		HouseModel house = houseRepo.findHouseById(id);
		System.out.println(house.getHouseAddress());
		return house;
	}

	public void saveReport(ReportModel report) {
		// TODO Auto-generated method stub
		reportRepo.save(report);
	}

	public void saveReview(ReviewModel review) {
		// TODO Auto-generated method stub
		reviewRepo.save(review);
	}

}
