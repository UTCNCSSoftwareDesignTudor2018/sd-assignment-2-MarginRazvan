package com.StudentManagement.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.StudentManagement.persistence.builder.StudentReportBuilder;

public class StudentReport {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Student student;
	

	
	
	
	public StudentReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentReport(StudentReportBuilder builder)
	{
		this.id = builder.id;
		this.student=builder.student;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
