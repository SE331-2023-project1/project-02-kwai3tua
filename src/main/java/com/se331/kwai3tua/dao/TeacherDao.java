package com.se331.kwai3tua.dao;

import com.se331.kwai3tua.entity.Teacher;
import com.se331.kwai3tua.security.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherDao {
    Integer getTeacherSize();
    Teacher save(Teacher teacher);
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Page<Teacher> getTeachers(String name, Pageable page);
    Teacher getTeacher(Long id);
    User updateTeacher(Long id, User updatedUser);
    Teacher addStudent(Integer studentId, Integer teacherId);
}