package com.qsp.studentcrud.exception;

public class IdNotFound extends RuntimeException {

	 String message;
	 
	@Override
	public String getMessage() {
	
		return message;
	}
	
	public IdNotFound(String message) {
		
		super();
		this.message = message;
	}
}
