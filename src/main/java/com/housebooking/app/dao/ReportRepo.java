package com.housebooking.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.housebooking.app.model.ReportModel;


@Repository
public interface ReportRepo extends JpaRepository<ReportModel, Long> {

}
