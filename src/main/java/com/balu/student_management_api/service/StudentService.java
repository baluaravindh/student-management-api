package com.balu.student_management_api.service;

import com.balu.student_management_api.dto.StudentRequestDto;
import com.balu.student_management_api.dto.StudentResponseDto;
import com.balu.student_management_api.entity.Student;
import com.balu.student_management_api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponseDto createStudent(StudentRequestDto request) {

        Student student = Student.builder().
                name(request.getName())
                .email(request.getEmail())
                .course(request.getCourse())
                .build();
        log.info("Creating student{}", request.getName());
        Student savedStudent = studentRepository.save(student);
        log.info("Student created successfully with id {}", savedStudent.getId());
        return StudentResponseDto.builder()
                .id(savedStudent.getId())
                .name(savedStudent.getName())
                .email(savedStudent.getEmail())
                .course(savedStudent.getCourse())
                .build();
    }

    public List<StudentResponseDto> getStudents() {
        return studentRepository.findAll()
                .stream()
                .map(student -> StudentResponseDto.builder()
                        .id(student.getId())
                        .name(student.getName())
                        .email(student.getEmail())
                        .course(student.getCourse())
                        .build())
                .collect(Collectors.toList());
    }

    public StudentResponseDto getStudentById(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .course(student.getCourse())
                .build();
    }
}
