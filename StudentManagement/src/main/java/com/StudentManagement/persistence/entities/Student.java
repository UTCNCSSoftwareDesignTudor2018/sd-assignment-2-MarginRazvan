package com.StudentManagement.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	
	
	@OneToMany(mappedBy="student")
	@JsonIgnore
	private List<Enrollment> enrollments;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String cnp;
	
	@Column
	private int studentGroup;
	
	

	public Student() {
	}

	public Student(String name, String email, String cnp, int student_group) {
		super();
		this.name = name;
		this.email = email;
		this.cnp = cnp;
		this.studentGroup = student_group;
		this.enrollments= new ArrayList<Enrollment>();
	}

	public Integer getStudent_id() {
		return id;
	}

	public void setStudent_id(int student_id) {
		this.id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public int getStudent_group() {
		return studentGroup;
	}

	public void setStudent_group(int student_group) {
		this.studentGroup = student_group;
	}
	
	

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
	
	public void addEnrollment(Enrollment e)
	{
		this.enrollments.add(e);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", cnp=" + cnp
				+ ", student_group=" + studentGroup + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (cnp == null) {
			if (other.cnp != null)
				return false;
		} else if (!cnp.equals(other.cnp))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (studentGroup != other.studentGroup)
			return false;
		return true;
	}
	
	

}
