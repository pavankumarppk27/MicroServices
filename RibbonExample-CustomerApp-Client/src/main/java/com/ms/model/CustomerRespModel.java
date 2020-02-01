package com.ms.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class CustomerRespModel {
	
	private Integer customerId;
	private String custmerName;
	private String customerJob;
	private Double customerSal;
	private AddressModel addrModel;
	
	
	public CustomerRespModel( String custmerName, String customerJob, Double customerSal,
			AddressModel addrModel) {
		super();
		
		this.custmerName = custmerName;
		this.customerJob = customerJob;
		this.customerSal = customerSal;
		this.addrModel = addrModel;
	}
    
	
	public CustomerRespModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
