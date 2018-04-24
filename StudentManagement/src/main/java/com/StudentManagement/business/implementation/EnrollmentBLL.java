package com.StudentManagement.business.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.repository.EnrollmentRepository;

@Service
public class EnrollmentBLL {
	
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	
	public List<Enrollment> findByStudentId(Integer Id)
	{
		return enrollmentRepository.findByStudentId(Id);
	}
	
	public void enroll(Student student,Course course)
	{
	 Enrollment e= new Enrollment(student,course);
	 enrollmentRepository.save(e);
	}

}
