package com.StudentManagement.business.interfaces;

import java.util.List;
import java.util.Optional;

import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.entities.Teacher;

public interface TeacherBLLInterface {
	public Optional<Teacher> getTeacher(Integer id);

	public void updateInfo(Teacher s);

	public List<Course> getCourses(Integer id);

	public List<Student> getStudents(Integer id);

	public void unenroll(Integer studentId, Integer courseId);

	public void setGrade(Enrollment e);

}
