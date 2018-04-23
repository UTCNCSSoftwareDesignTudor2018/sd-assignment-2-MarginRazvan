package com.StudentManagement.business.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.repository.StudentRepository;

@Service
public class StudentBLL {

	@Autowired
	private StudentRepository studentRepository;
	
	//@Autowired CourseBLL courseBLL;
	
	@Autowired EnrollmentBLL enrollmentBLL;
	
	
	public List<Student> getAllStudents()
	{
		List<Student> students= studentRepository.findAll();
		
		return students;
	}
	
	
	public Optional<Student> getStudent(Integer id)
	{
		return studentRepository.findById(id);
	}
	
	public List<Course> viewEnrollments(Integer id)
	{
		List<Enrollment> enrollments = enrollmentBLL.findByStudentId(id);
		
		List<Course> courses = new ArrayList<Course>(enrollments.size());

		for (int i=0; i<enrollments.size();i++)
		{
			courses.add(enrollments.get(i).getCourse());
		}
		return courses;
	}
	
	public Student updateInfo(Student s)
	{
		return studentRepository.save(s);
	}
	
	
}
