package com.StudentManagement.business.interfaces;

import java.util.Optional;

import com.StudentManagement.persistence.entities.StudentReport;
import com.StudentManagement.persistence.entities.Student;

public interface ReportBLLInterface {
	public void save(StudentReport report);
	public Optional<StudentReport> getReport(Integer id);

}
