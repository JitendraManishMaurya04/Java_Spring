package com.mySpringPorject.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponseHandling {
	
	private Date timeStamp;
	private String message;
	private String details;
	
	public ExceptionResponseHandling(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponseHandling [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details
				+ "]";
	}
	
	
	
}
