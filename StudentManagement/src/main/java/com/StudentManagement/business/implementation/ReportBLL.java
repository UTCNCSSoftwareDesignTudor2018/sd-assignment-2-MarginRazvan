package com.StudentManagement.business.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.business.interfaces.ReportBLLInterface;
import com.StudentManagement.persistence.entities.StudentReport;
import com.StudentManagement.persistence.entities.Student;
import com.StudentManagement.persistence.repository.ReportRepository;

@Service
public class ReportBLL implements ReportBLLInterface {
	
	@Autowired
	private ReportRepository reportRepository;
	
	
	public void save(Student student)
	{
		StudentReport report= new StudentReport();
		report.setStudent(student);
		report.setId(student.getStudent_id());
		reportRepository.save(report);
	}
	
	public Optional<StudentReport> getReport(Integer id)
	{
		return reportRepository.findById(id);
	}
	
	

}
