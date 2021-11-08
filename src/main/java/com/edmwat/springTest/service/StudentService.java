package com.edmwat.springTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.edmwat.springTest.model.Student;
import com.edmwat.springTest.repo.StudentRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

@Service 
public class StudentService {
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student registerNewStudent(Student student) {
		boolean ifExists= studentRepository.findStudentByEmail(student.getEmail());
		
		if(ifExists) {
			throw new HttpClientErrorException(null, "Email "+student.getEmail() +" taken");
		}
		return studentRepository.save(student);
	}
	

}
