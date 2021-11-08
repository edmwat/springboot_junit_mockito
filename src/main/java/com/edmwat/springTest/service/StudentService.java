package com.edmwat.springTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edmwat.springTest.model.Student;
import com.edmwat.springTest.repo.StudentRepository;

@Service 
public class StudentService {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAllStudents(){
		return List.of(
				new Student(null,"Jame Bond","james@gmail.com"),
				new Student(null,"Anna Marie","anna@gmail.com"),
				new Student(null,"Will Smith","smith@gmail.com")
				);
	}
	

}
