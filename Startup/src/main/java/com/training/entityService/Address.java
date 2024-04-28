package com.training.entityService;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="detailedAddress")
    private String detailedAddress;
	
	@Column(name="city")
    private String city;
	
	@Column(name="state")
    private String state;
	
	@Column(name="pincode")
    private String pincode;
	
	
	
	 // Constructors, getters, and setters
	
	
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address(String detailedAddress, String city, String state, String pincode) {
		super();
		this.detailedAddress = detailedAddress;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

   
    
}