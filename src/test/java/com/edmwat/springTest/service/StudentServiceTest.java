package com.edmwat.springTest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;

import com.edmwat.springTest.model.Student;
import com.edmwat.springTest.repo.StudentRepository;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
	
	@Mock private StudentRepository studentRepository;
	private StudentService underTest;
	
	@BeforeEach
	void setup() {
		underTest = new StudentService(studentRepository);
	}

	@Test
	void canGetAllStudents() {
		//when
		underTest.getAllStudents();
		//then
		verify(studentRepository).findAll();
		
	}

	@Test
	void postStudentToDb() {
		//given
		Student  student = new Student(1l,"Jenny scott","jenny@gmail.com");	
		
		//when
		underTest.registerNewStudent(student);
		
		//then
		ArgumentCaptor<Student> studentArgumentCaptor = 
				ArgumentCaptor.forClass(Student.class);
		
		verify(studentRepository).save(studentArgumentCaptor.capture());
		
		Student capturedStudent = studentArgumentCaptor.getValue();
		
		assertThat(capturedStudent).isEqualTo(student);
		
	}
	@Disabled
	void willThrowWhenEmailExist() {

		Student  student = new Student(1l,"Jenny scott","jenny@gmail.com");	
		
		underTest.registerNewStudent(student);
		assertThatThrownBy(()->underTest.registerNewStudent(student))
			.isInstanceOf(HttpClientErrorException.class)
			.hasMessageContaining("Email "+student.getEmail() +" taken");
	}
}
