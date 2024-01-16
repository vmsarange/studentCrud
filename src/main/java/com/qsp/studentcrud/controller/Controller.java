package com.qsp.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("/getStudent")
	public ResponseEntity<ResponseStructure<Student>> getStudent(@RequestParam int id) {
		
		return service.getStudent(id);
	}
	@GetMapping("/getAll")
    public ResponseEntity<ResponseStructure<List<Student>>> getAll() {
		
    	return service.getAll();
	}
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id) {
		
		return service.deleteStudent(id);
	}
	@PostMapping("/updateStudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student,@RequestParam int id) {
		
		return service.update(student, id);
	}
}
