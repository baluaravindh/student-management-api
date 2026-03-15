package com.balu.student_management_api.controller;

import com.balu.student_management_api.entity.Student;
import com.balu.student_management_api.repository.StudentRepository;
import com.balu.student_management_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable long id){
        return studentService.getStudentById(id);
    }
}
