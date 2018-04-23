package com.StudentManagement.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy="course")
	@JsonIgnore
	private List<Enrollment> enrollments;
	
	@ManyToOne
	@JoinColumn(name="teacher_id")
	@JsonIgnore
	private Teacher teacher;
	
	@Column
	private String name;
	
	public Course()
	{
		
	}

	public Course(Teacher teacher, String name) {
		super();
		this.teacher = teacher;
		this.name = name;
		this.enrollments= new ArrayList<Enrollment>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

	
}
