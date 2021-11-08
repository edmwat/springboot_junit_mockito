package com.edmwat.springTest.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edmwat.springTest.model.Student;
import com.edmwat.springTest.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		return ResponseEntity.ok().body(studentService.getAllStudents());
	}

}
