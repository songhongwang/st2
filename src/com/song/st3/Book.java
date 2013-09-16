package com.song.st3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.struts2.util.IteratorGenerator.Converter;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.opensymphony.xwork2.ActionSupport;

public class Book extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date publish;

	private List<String> books = new ArrayList<String>();
	private List<String> books2 = new ArrayList<String>();
	private String bname;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
		publish=new Date();
		books.add("aaa");
		books.add("ddddff");
		books.add("bbb");
		books.add("cccccc");
		books.add("bbb");
		books.add("bbb");
		books2.add("”¢”Ô");
		books2.add("”ÔŒƒ");
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public Date getPublish() {
		return publish;
	}

	public void setPublish(Date publish) {
		this.publish = publish;
	}

	public List<String> getBooks() {

		return books;
	}

	public void setBooks(List<String> books) {
		// this.books = books;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public List<String> getBooks2() {

		return books2;
	}

	public void setBooks2(List<String> books2) {
		this.books2 = books2;
	}
	
	public Converter getMyConverter(){
		return new Converter(){

			@Override
			public Object convert(String arg0) throws Exception {
				// TODO Auto-generated method stub
				return arg0.toUpperCase();
			}
			
		};
	}
	
	public Comparator getMyComparator(){
		return new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return o1.toString().compareTo(o2.toString());
			}
		};
	}
	
	public Decider getMyDecider(){
		return new Decider() {
			
			@Override
			public boolean decide(Object arg0) throws Exception {
				// TODO Auto-generated method stub
				return arg0.toString().length()>4;
			}
		};
	}
}
