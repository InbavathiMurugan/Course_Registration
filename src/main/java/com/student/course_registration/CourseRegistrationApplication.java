package com.student.course_registration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.student.course_registration.model.Course;
import com.student.course_registration.repository.CourseRepository;

@SpringBootApplication
public class CourseRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrationApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialCourses(CourseRepository courseRepo) {
        return args -> {
            if (courseRepo.count() == 0) {
                courseRepo.save(new Course("Data Structures", "Learn arrays, linked lists, trees."));
                courseRepo.save(new Course("Operating Systems", "Process management, scheduling."));
                courseRepo.save(new Course("Database Systems", "SQL, normalization, transactions."));
                courseRepo.save(new Course("Computer Networks", "Protocols, TCP/IP, routing."));
            }
        };
    }
}
