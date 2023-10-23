package com.se331.kwai3tua.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherBriefDTO {
    Long id;
    String username;
    String firstname;
    String lastname;
    String image;
}