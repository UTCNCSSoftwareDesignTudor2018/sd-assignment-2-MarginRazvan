package com.StudentManagement.business.interfaces;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StudentManagement.persistence.entities.Course;
@Service
public interface CourseBLLInterface {
	public Optional<Course> getCourse(Integer id);

}
