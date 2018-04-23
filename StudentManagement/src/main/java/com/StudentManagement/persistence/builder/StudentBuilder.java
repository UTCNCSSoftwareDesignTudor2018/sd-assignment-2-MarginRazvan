package com.StudentManagement.persistence.builder;

import com.StudentManagement.persistence.entities.Student;

public class StudentBuilder {
	
	private Integer id;
	private String name;
	private String cnp;
	private String email;
	private int studentGroup;
	
	
	
	
	public void setEmail(String email) {
		this.email = email;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setCnp(String cnp) {
		this.cnp = cnp;
	}




	public void setStudentGroup(int studentGroup) {
		this.studentGroup = studentGroup;
	}




	public Student createStudent()
	{
		return new Student(this.name,this.email,this.cnp,this.studentGroup);
		
	}

}
