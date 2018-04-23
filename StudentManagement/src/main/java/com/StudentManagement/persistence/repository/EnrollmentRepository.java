package com.StudentManagement.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagement.persistence.entities.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
	
	List<Enrollment> findByStudentId(Integer studentId);
	
	List<Enrollment> findByCourseId(Integer courseId);

}
