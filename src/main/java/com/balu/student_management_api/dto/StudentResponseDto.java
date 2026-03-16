package com.balu.student_management_api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponseDto {

    private long id;
    private String name;
    private String email;
    private String course;
}
