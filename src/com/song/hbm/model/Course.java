package com.song.hbm.model;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private int id;
	private String name;
	private Set stus=new HashSet<Student>();
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
	public Set getStus() {
		return stus;
	}
	public void setStus(Set stus) {
		this.stus = stus;
	}
 
	
}
