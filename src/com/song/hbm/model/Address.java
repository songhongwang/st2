package com.song.hbm.model;

public class Address {
private String street;
private String city;
private String province;
private String zipcode;

private Customer customer;

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getProvince() {
	return province;
}

public void setProvince(String province) {
	this.province = province;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

}
