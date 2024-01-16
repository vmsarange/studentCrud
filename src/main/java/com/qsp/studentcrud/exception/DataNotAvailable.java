package com.qsp.studentcrud.exception;

public class DataNotAvailable extends RuntimeException{

	 String message;
	 
	 @Override
	public String getMessage() {
		
		return super.getMessage();
	}
	 public DataNotAvailable(String message)
	 {
		 super();
		 
		 this.message= message;
	 }
}
