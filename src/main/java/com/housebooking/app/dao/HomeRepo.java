package com.housebooking.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.housebooking.app.model.UserModel;

public interface HomeRepo extends JpaRepository<UserModel, Long>{

}
