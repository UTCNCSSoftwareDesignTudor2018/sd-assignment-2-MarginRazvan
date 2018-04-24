package com.StudentManagement.business.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.business.interfaces.CourseBLLInterface;
import com.StudentManagement.business.interfaces.EnrollmentBLLInterface;
import com.StudentManagement.business.interfaces.StudentBLLInterface;
import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.repository.StudentRepository;

@Service
public class StudentBLL implements StudentBLLInterface {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired CourseBLLInterface courseBLL;
	
	@Autowired EnrollmentBLLInterface enrollmentBLL;
	
	
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
	
	public List<Enrollment> viewGrades(Integer id) 
	{
		return enrollmentBLL.findByStudentId(id);
	}
	
	public void updateInfo(Student s)
	{
		 studentRepository.save(s);
	}
	
	public void enroll(Integer student_id,Integer course_id)
	{
		Optional<Student> student = studentRepository.findById(student_id);
		Optional<Course> course = courseBLL.getCourse(course_id);
		
		enrollmentBLL.enroll(student.get(),course.get());
		
	}



	
	
	
	
}
