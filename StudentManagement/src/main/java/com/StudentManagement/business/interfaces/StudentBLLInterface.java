package com.StudentManagement.business.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.Student;

@Service
public interface StudentBLLInterface {
	public List<Student> getAllStudents();
	
	public Optional<Student> getStudent(Integer id);

	
	public List<Course> viewEnrollments(Integer id);

	
	public List<Enrollment> viewGrades(Integer id) ;

	
	public void updateInfo(Student s);

	
	public void enroll(Integer student_id,Integer course_id);

}
