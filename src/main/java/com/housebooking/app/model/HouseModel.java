package com.housebooking.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "houses")
public class HouseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String houseOwnerMail;
	private String houseName;
	private String houseAddress;
	private String houseType;
	private String houseContact;
	private String houseRent;
	private String houseDetails;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String housePhoto;
	private int isBooked;
	private int isHide;
	
	
	
}
