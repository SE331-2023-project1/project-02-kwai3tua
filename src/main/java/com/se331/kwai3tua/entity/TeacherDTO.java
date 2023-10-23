package com.se331.kwai3tua.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    Long id;
    List<String> images;
    String department;
    List<TeacherOwnStudentDTO> ownStudent = new ArrayList<>();
}