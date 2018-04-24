package com.StudentManagement.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.StudentManagement.persistence.entities.StudentReport;

public interface ReportRepository extends MongoRepository<StudentReport, Integer> {

}
