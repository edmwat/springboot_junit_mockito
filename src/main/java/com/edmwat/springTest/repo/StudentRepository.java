package com.edmwat.springTest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edmwat.springTest.model.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student,Long> {
	boolean findStudentByEmail(String email);

}
