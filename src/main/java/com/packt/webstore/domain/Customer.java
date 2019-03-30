package com.packt.webstore.domain;

public class Customer {
	private String customerId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getNoOfOrdersMade() {
		return noOfOrdersMade;
	}

	public void setNoOfOrdersMade(Integer noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

	private String name;
	private String address;
	private Integer noOfOrdersMade;
}
