package com.StudentManagement.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagement.persistence.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
