package com.StudentManagement.persistence.builder;

import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.EnrollmentWrapper;
import com.StudentManagement.persistence.entities.Student;

public class EnrollmentBuilder {

	public EnrollmentWrapper id;
	
	public Student student;
	
	public Course course;
	
	//public Integer grade;
	
	
	public EnrollmentBuilder(Integer student_id,Integer course_id)
	{
		this.id = new EnrollmentWrapper(student_id,course_id);
	}
	
	public EnrollmentBuilder setStudent(Student s)
	{
		this.student = s;
		return this;
	}
	
	public EnrollmentBuilder setCourse(Course c)
	{
		this.course=c;
		return this;
	}
	
//	public EnrollmentBuilder setGrade(Integer g)
//	{
//		this.grade=g;
//		return this;
//	}
//	
	
	public Enrollment build()
	{
		return new Enrollment(this);
	}
	
}
