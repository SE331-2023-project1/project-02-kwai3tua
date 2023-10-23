package com.se331.kwai3tua.entity;

import com.se331.kwai3tua.security.user.Role;
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
public class DetailedTeacherDTO {
    Long id;
    String username;
    String firstname;
    String lastname;
    String email;
    List<Role> roles = new ArrayList<>();
    String image;
    String department;
    List<TeacherOwnStudentDTO> ownStudent = new ArrayList<>();
}