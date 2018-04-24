package com.StudentManagement.presentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.StudentManagement.business.interfaces.TeacherBLLInterface;
import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.EnrollmentWrapper;
import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.entities.Teacher;

@RestController
@RequestMapping(value="/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherBLLInterface teacherBLL;
	
	
	@RequestMapping(value="/{id}/profile")
	public Optional<Teacher> getTeacher(@PathVariable String id)
	{
		return teacherBLL.getTeacher(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/updateProfile",method=RequestMethod.POST)
	public void updateProfile(@RequestBody Teacher t)
	{
		teacherBLL.updateInfo(t);
	}
	
	@RequestMapping(value="/{id}/courses")
	public List<Course> getCourses(@PathVariable String id)
	{
		return teacherBLL.getCourses(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/course/{id}/")
	public List<Student> getStudents(@PathVariable String id)
	{
		return teacherBLL.getStudents(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/unenroll",method=RequestMethod.POST)
	public void enroll(@RequestBody EnrollmentWrapper e)
	{
		teacherBLL.unenroll(e.getStudentId(),e.getCourseId());
	}
	
	@RequestMapping(value="/setGrade",method=RequestMethod.POST)
	public void enroll(@RequestBody Enrollment e)
	{
		teacherBLL.setGrade(e);
	}
	
	
	

}
