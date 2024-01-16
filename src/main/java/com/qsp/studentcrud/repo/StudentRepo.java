package com.qsp.studentcrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.studentcrud.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	   
}
