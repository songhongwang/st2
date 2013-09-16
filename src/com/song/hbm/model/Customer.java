package com.song.hbm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer{

	private int id;
	private String name;
	private int age;
	private String des;
	private double price;
	private double total;
	
	private Set orders=new HashSet<Order>();
	
	private Address homeAddress;
	private Address comAddress;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	 

	public Set getOrders() {
		return orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getComAddress() {
		return comAddress;
	}

	public void setComAddress(Address comAddress) {
		this.comAddress = comAddress;
	}
 
	
	
}
