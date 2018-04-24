package com.StudentManagement.presentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.StudentManagement.business.implementation.StudentBLL;
import com.StudentManagement.persistence.builder.StudentBuilder;
import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.EnrollmentWrapper;
import com.StudentManagement.persistence.entities.Student;

@RestController
@RequestMapping(value="/student")
public class StudentController {

	@Autowired
	private StudentBLL studentBLL;
	
	
	
	@RequestMapping(value="/getStudents")
	public List<Student> getStudents()
	{
		return studentBLL.getAllStudents();
	}
	
	
	@RequestMapping(value="/{id}/profile")
	public Optional<Student> getStudent(@PathVariable String id)
	{
		return studentBLL.getStudent(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/updateProfile",method=RequestMethod.POST)
	public void updateProfile(@RequestBody Student s)
	{
		studentBLL.updateInfo(s);
	}
	
	
	@RequestMapping(value="/{id}/enrollments")
	public List<Course> getEnrollments(@PathVariable String id)
	{
		return studentBLL.viewEnrollments(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/enroll",method=RequestMethod.POST)
	public void enroll(@RequestBody EnrollmentWrapper e)
	{
		studentBLL.enroll(e.getStudentId(),e.getCourseId());
	}
	
	@RequestMapping(value="/{id}/grades")
	public List<Enrollment> getGrades(@PathVariable String id)
	{
	
		return studentBLL.viewGrades(Integer.parseInt(id));

	}
	
	
	
	
}
