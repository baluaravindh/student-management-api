package com.balu.student_management_api.controller;

import com.balu.student_management_api.dto.StudentRequestDto;
import com.balu.student_management_api.dto.StudentResponseDto;
import com.balu.student_management_api.entity.Student;
import com.balu.student_management_api.repository.StudentRepository;
import com.balu.student_management_api.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponseDto createStudent(@Valid @RequestBody StudentRequestDto request) {
        return studentService.createStudent(request);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDto getStudentByID(@PathVariable long id){
        return studentService.getStudentById(id);
    }
}
