package com.qsp.studentcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qsp.studentcrud.dto.Student;
import com.qsp.studentcrud.repo.StudentRepo;

@Repository
public class StudentDao {
    
	@Autowired
	private StudentRepo repo;
	
	public Student saveStudent(Student student) {
		
		return repo.save(student);
	}
	public Student getStudent(int id) {
		
		Optional<Student> optional = repo.findById(id);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	public List<Student> getAll() {
		
		return repo.findAll();
	}
	public Student deleteStudent(int id) {
		
		Optional<Student> optional = repo.findById(id);
		
		if(optional.isEmpty())
		{
			return null;
		}
		repo.deleteById(id);
		
		return optional.get();
	}
	public Student updateStudent(Student student, int id) {
		
		Student dbStudent = getStudent(id);
		
		if(dbStudent!=null)
		{
			student.setId(id);
			return repo.save(student);
		}
		return null;
	}
	
}
