package com.ms.model;

import lombok.Data;

@Data
public class AddressModel {
	
	private Integer addressAppPortNo;
	private Long phoneNumber;
	private String location;
	private String houseNo;
	
	public AddressModel(Long phoneNumber, String location, String houseNo) {
		super();
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.houseNo = houseNo;
	}
	
	public AddressModel() {
		// TODO Auto-generated constructor stub
	}

}
