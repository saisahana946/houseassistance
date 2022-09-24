package com.housebooking.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.housebooking.app.dao.HouseBookingRepo;
import com.housebooking.app.model.HouseBookingModel;

@Service
public class HouseBookingService {
	
	@Autowired
	private HouseBookingRepo houseBook;

	public void savehousebooking(HouseBookingModel housebook) {
		houseBook.save(housebook);
		
	}

	public int authenticateHouseBooking(HouseBookingModel housebooking) {
		List<HouseBookingModel> hbmodel = houseBook.findAll();
		long c= 0;
		c = hbmodel.stream().filter(n -> n.getEmail().equals(housebooking.getEmail()) && n.getPassword().equals(housebooking.getPassword())).count();
		
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
