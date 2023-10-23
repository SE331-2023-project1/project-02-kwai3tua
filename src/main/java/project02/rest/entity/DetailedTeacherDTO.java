package project02.rest.entity;

import project02.rest.security.user.Role;

import java.util.ArrayList;
import java.util.List;

public class DetailedTeacherDTO {
    // User ID
    Long id;
    String username;
    String firstname;
    String lastname;
    String email;
    List<Role> roles = new ArrayList<>();

    // Fields from TeacherDTO
    String image;
    String department;
    List<TeacherOwnStudentDTO> ownStudent = new ArrayList<>();
}

