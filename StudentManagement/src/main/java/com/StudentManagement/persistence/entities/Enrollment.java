package com.StudentManagement.persistence.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.StudentManagement.persistence.builder.EnrollmentBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="enrollments")
public class Enrollment {
	
	@EmbeddedId
	private EnrollmentWrapper id;
	
	@Column(nullable=true)
	private Integer grade;
	
	@ManyToOne
	@JsonIgnore
	@MapsId("studentId")
	private Student student;
	
	@ManyToOne
	@JsonIgnore
	@MapsId("courseId")
	private Course course;
	
	
	public Enrollment()
	{
		
	}






	public Enrollment( Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
		this.id = new EnrollmentWrapper(student.getStudent_id(),course.getId());
	}
	
	





	public Enrollment(EnrollmentBuilder builder) {
		// TODO Auto-generated constructor stub
		
		this.id = builder.id;
		this.course=builder.course;
		this.student=builder.student;
	
	}


	public EnrollmentWrapper getId() {
		return id;
	}





	public void setId(EnrollmentWrapper id) {
		this.id = id;
	}





	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	

}
