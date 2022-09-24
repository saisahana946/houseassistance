package com.housebooking.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housebooking.app.model.HouseBookingModel;

@Repository
public interface HouseBookingRepo extends JpaRepository<HouseBookingModel, Long>{
	
}
