package com.caocao.springSecDemo.controller;

import com.caocao.springSecDemo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentControler {

    List<Student> students;

    public StudentControler() {
        students = new ArrayList<>(List.of(
                new Student(1, "Navin", "Java"),
                new Student(2, "Kiran", "Blockchain")));
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("students")
    public List<Student> addStudent(@RequestBody Student student) {
        return students;
    }

}
