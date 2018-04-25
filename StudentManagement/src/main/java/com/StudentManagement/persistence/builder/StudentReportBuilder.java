package com.StudentManagement.persistence.builder;

import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.entities.StudentReport;

public class StudentReportBuilder {
	
	public Integer id;
	
	public Student student;
	
	
	
	public StudentReportBuilder()
	{
		
	}
	
	public StudentReportBuilder setId(Integer id)
	{
		this.id= id;
		return this;
	}
	
	public StudentReportBuilder setStudent(Student student)
	{
		this.student=student;
		return this;
	}
	
	
	public StudentReport build()
	{
		return new StudentReport(this);
	}

}
