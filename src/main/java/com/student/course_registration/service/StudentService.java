package com.student.course_registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.course_registration.model.Student;
import com.student.course_registration.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }
}
