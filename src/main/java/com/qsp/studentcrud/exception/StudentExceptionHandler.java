package com.qsp.studentcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.studentcrud.util.ResponseStructure;
@ControllerAdvice
public class StudentExceptionHandler extends ResponseEntityExceptionHandler{
    
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFound idNF) {
		
		ResponseStructure<String> rStructure = new ResponseStructure<String>();
		
		rStructure.setMessage(idNF.getMessage());
		rStructure.setStatus(HttpStatus.NOT_FOUND.value());
		rStructure.setData("Student with the given id not found");
		
		return new ResponseEntity<ResponseStructure<String>>(rStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DataNotAvailable.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(DataNotAvailable dNA) {
		
		ResponseStructure<String> rStructure = new ResponseStructure<String>();
		
		rStructure.setMessage(dNA.getMessage());
		rStructure.setStatus(HttpStatus.NOT_FOUND.value());
		rStructure.setData("Data you are looking for is not available");
		
		return new ResponseEntity<ResponseStructure<String>>(rStructure, HttpStatus.NOT_FOUND);
	}
	 
}
