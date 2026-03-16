package com.balu.student_management_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentRequestDto {

    @NotBlank(message = "Name is required.")
    private String name;

    @Email(message = "Invalid email format.")
    private String email;

    @NotBlank(message = "Course is required.")
    private String course;
}
