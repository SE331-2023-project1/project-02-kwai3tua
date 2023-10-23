package com.se331.kwai3tua.service;

import com.se331.kwai3tua.security.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.se331.kwai3tua.entity.Student;

public interface StudentService {
    Integer getStudentsSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> getStudents(String filter, Pageable pageable);
    Student getStudent(Long id);
    Student save(Student student);
    User updateStudent(Long id, User user);
    User findUserByStudentId(Long studentUserId);
    Page<Student> getStudentTeacherIsNull(Integer perPage, Integer page);
}