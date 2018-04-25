package com.StudentManagement.business.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.business.interfaces.CourseBLLInterface;
import com.StudentManagement.business.interfaces.EnrollmentBLLInterface;
import com.StudentManagement.persistence.entities.StudentReport;
import com.StudentManagement.business.interfaces.ReportBLLInterface;
import com.StudentManagement.business.interfaces.StudentBLLInterface;
import com.StudentManagement.business.interfaces.TeacherBLLInterface;
import com.StudentManagement.persistence.builder.StudentReportBuilder;
import com.StudentManagement.persistence.entities.Course;
import com.StudentManagement.persistence.entities.Enrollment;
import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.entities.Teacher;
import com.StudentManagement.persistence.repository.TeacherRepository;

@Service
public class TeacherBLL implements TeacherBLLInterface {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	@Autowired 
	private CourseBLLInterface courseBLL;
	
	@Autowired
	private EnrollmentBLLInterface enrollmentBLL;
	
	@Autowired
	private StudentBLLInterface studentBLL;
	
	@Autowired
	private ReportBLLInterface reportBLL;
	
	
	public Optional<Teacher> getTeacher(Integer id)
	{
		return teacherRepository.findById(id);
	}
	
	public void updateInfo(Teacher t)
	{
		 teacherRepository.save(t);
	}
	
	public List<Course> getCourses(Integer id)
	{
		
		return teacherRepository.findById(id).get().getCourses();
		
	}

	@Override
	public List<Student> getStudents(Integer id) {
		
		
		List<Enrollment> enrollments = courseBLL.getCourse(id).get().getEnrollments();
		List<Student> students = new ArrayList<Student>();
		
		for (int i=0; i<enrollments.size();i++)
		{
			students.add(enrollments.get(i).getStudent());
		}
		
		return students;
	}
	
	public void unenroll(Integer studentId, Integer courseId)
	{
		Optional<Student> student = studentBLL.getStudent(studentId);
		Optional<Course> course = courseBLL.getCourse(courseId);
		
		enrollmentBLL.unenroll(student.get(),course.get());
	}

	@Override
	public void setGrade(Enrollment e) {
		enrollmentBLL.updateGrade(e);
		
	}

	@Override
	public void createReport(Student s) {
		
		
		StudentReport report = new StudentReportBuilder().setId(s.getStudent_id()).setStudent(s).build();
		
		reportBLL.save(report);		
	}

	@Override
	public Optional<StudentReport> getReport(Integer id) {
		return reportBLL.getReport(id);
	}

}
