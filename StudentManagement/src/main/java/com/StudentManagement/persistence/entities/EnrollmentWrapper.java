package com.StudentManagement.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnrollmentWrapper implements Serializable {
	
	@Column(name="studentId")
	private Integer studentId;
	
	@Column(name="courseId")
	private Integer courseId;

	public EnrollmentWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnrollmentWrapper(Integer studentId, Integer courseId) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	

}
