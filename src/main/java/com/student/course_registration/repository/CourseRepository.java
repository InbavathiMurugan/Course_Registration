package com.student.course_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.course_registration.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
