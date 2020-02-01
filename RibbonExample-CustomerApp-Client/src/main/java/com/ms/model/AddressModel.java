package com.ms.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class AddressModel {
	
	private Integer addressAppPortNo;
	private Long phoneNumber;
	private String location;
	private String houseNo;


}
