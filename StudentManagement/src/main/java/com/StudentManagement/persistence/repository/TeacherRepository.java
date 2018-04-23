package com.StudentManagement.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagement.persistence.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
