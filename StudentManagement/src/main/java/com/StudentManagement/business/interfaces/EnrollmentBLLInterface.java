package com.StudentManagement.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.Student;

@Service
public interface EnrollmentBLLInterface {
	
	public List<Enrollment> findByStudentId(Integer Id);

	
	public void enroll(Student student,Course course);


}
