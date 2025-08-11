package com.student.course_registration.controller;

import com.student.course_registration.model.Course;
import com.student.course_registration.model.Student;
import com.student.course_registration.repository.CourseRepository;
import com.student.course_registration.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class StudentController {

    private final CourseRepository courseRepo;
    private final StudentService studentService;

    public StudentController(CourseRepository courseRepo, StudentService studentService) {
        this.courseRepo = courseRepo;
        this.studentService = studentService;
    }

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseRepo.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute @Valid Student student,
                             BindingResult bindingResult,
                             @RequestParam(value = "courseIds", required = false) List<Long> courseIds,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("courses", courseRepo.findAll());
            return "register";
        }

        Set<Course> selected = new HashSet<>();
        if (courseIds != null) {
            selected.addAll(courseRepo.findAllById(courseIds));
        }
        student.setCourses(selected);
        studentService.save(student);
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
}
