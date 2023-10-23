package com.se331.kwai3tua.dao;

import com.se331.kwai3tua.entity.Student;
import com.se331.kwai3tua.security.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentDao {
    Integer getStudentSize();
    Student save(Student student);
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> getStudents(String filter, Pageable page);
    Student getStudent(Long id);
    User updateStudent(Long id, User updatedUser);
}