package com.student.course_registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/signup")
    public String registerUser() {
        return "redirect:/login";
    }
}
