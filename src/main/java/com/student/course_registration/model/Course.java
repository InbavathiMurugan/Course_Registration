package com.student.course_registration.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 1000)
    private String description;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    // Constructors
    public Course() {}

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getters / Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Student> getStudents() { return students; }
    public void setStudents(Set<Student> students) { this.students = students; }
}
