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
	
//	@RequestMapping(value="/updateProfile",method=RequestMethod.PUT)
//	public void updateProfile(@RequestBody Student s)
//	{
//		StudentBuilder builder=new StudentBuilder();
//		builder.setCnp(s.getCnp());
//		builder.setEmail(s.getEmail());
//		builder.setId(s.getStudent_id());
//		builder.setName(s.getName());
//		builder.setStudentGroup(s.getStudent_group());
//		Student student =builder.createStudent();
//		studentBLL.updateInfo(student);
//	}
//	
	
	@RequestMapping(value="/{id}/enrollments")
	public List<Course> getEnrollments(@PathVariable String id)
	{
		return studentBLL.viewEnrollments(Integer.parseInt(id));
	}
	
	
	
	
}
