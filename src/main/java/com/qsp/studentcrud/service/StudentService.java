package com.qsp.studentcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.studentcrud.dao.StudentDao;
import com.qsp.studentcrud.dto.Student;
import com.qsp.studentcrud.util.ResponseStructure;

@Service
public class StudentService {
    
	@Autowired
	private StudentDao dao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student) {
		
		double securedMarks = student.getSecuredMarks();
		double totalMarks = student.getTotalMarks();
		
		double percentage = (securedMarks*100)/totalMarks;
		student.setPercentage(percentage);
		if (percentage>70 && percentage<=100) {
			
			student.setGradeDescription("First Class With Distinction");		
		}
		else if (percentage>60 && percentage<=70) {
			
			student.setGradeDescription("First Class");
		}
		else if (percentage>50 && percentage<=60) {
			
			student.setGradeDescription("Second Class");
		}
		else if (percentage>40 && percentage<=50) {
			
			student.setGradeDescription("Third class");
		}
		else if(percentage>=35 && percentage<=40)
		{
			student.setGradeDescription("Pass");
		}
		else {
			student.setGradeDescription("Fail");
		}
    ResponseStructure<Student> rStructure = new ResponseStructure<Student>();

		rStructure.setMessage("Student saved");
		rStructure.setStatus(HttpStatus.CREATED.value());
		rStructure.setData(dao.saveStudent(student));
		
	   return new ResponseEntity<ResponseStructure<Student>>(rStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Student>> getStudent(int id) {
		
		ResponseStructure<Student> rStructure = new ResponseStructure<Student>();

		rStructure.setMessage("Student Found");
		rStructure.setStatus(HttpStatus.FOUND.value());
		rStructure.setData(dao.getStudent(id));
		
		return new ResponseEntity<ResponseStructure<Student>> (rStructure,HttpStatus.FOUND);
	}
}
