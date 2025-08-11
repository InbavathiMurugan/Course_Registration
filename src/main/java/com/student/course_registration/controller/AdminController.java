package com.student.course_registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.course_registration.model.Course;
import com.student.course_registration.repository.CourseRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CourseRepository courseRepo;

    public AdminController(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/courses")
    public String courseList(Model model) {
        model.addAttribute("courses", courseRepo.findAll());
        model.addAttribute("course", new Course());
        return "admin-courses";
    }

    @PostMapping("/courses")
    public String addCourse(@ModelAttribute Course course) {
        courseRepo.save(course);
        return "redirect:/admin/courses";
    }
}
