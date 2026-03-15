package com.balu.student_management_api.service;

import com.balu.student_management_api.entity.Student;
import com.balu.student_management_api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
