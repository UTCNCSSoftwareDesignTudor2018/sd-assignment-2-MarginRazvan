package com.StudentManagement.business.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.business.interfaces.CourseBLLInterface;
import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.repository.CourseRepository;

@Service
public class CourseBLL implements CourseBLLInterface {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public Optional<Course> getCourse(Integer id)
	{
		return courseRepository.findById(id);
	}
	

	

}
