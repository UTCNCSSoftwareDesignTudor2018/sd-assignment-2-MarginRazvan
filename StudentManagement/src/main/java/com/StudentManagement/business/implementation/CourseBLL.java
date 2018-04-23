package com.StudentManagement.business.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.repository.CourseRepository;

@Service
public class CourseBLL {
	
	@Autowired
	private CourseRepository courseRepository;
	

}
