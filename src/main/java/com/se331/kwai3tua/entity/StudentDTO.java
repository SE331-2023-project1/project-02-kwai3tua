package com.se331.kwai3tua.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String image;
    String department;
    String email;
    TeacherBriefDTO teacher;
    String username;
    String firstname;
    String lastname;
}