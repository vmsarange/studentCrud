package com.qsp.studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.studentcrud.dto.Student;
import com.qsp.studentcrud.service.StudentService;
import com.qsp.studentcrud.util.ResponseStructure;

@RestController
public class Controller {
     
	@Autowired
	private StudentService service;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		
		return service.saveStudent(student);
	}
}