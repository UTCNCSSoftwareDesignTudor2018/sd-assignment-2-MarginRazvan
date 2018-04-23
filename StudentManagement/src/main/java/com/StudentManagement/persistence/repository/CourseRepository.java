package com.StudentManagement.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagement.persistence.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	
	public Optional<Course> findById(Integer id);

}
