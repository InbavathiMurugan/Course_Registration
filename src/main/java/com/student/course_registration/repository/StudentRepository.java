package com.student.course_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.course_registration.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
