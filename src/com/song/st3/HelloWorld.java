package com.song.st3;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public String execute() {
		// TODO Auto-generated method stub
		String msg = (String) ServletActionContext.getRequest().getAttribute("message");
		System.out.println(msg);
		return SUCCESS;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 
}
