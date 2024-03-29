package com.se331.kwai3tua.service;

import com.se331.kwai3tua.dao.TeacherDao;
import com.se331.kwai3tua.entity.Teacher;
import com.se331.kwai3tua.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    final TeacherDao teacherDao;

    @Override
    public Integer getTeachersSize() {
        return teacherDao.getTeacherSize();
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherDao.getTeachers(pageSize, page);
    }

    @Override
    public Page<Teacher> getTeachers(String filter, Pageable pageable) {
        return teacherDao.getTeachers(filter,pageable);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherDao.getTeacher(id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public User updateTeacher(Long id, User updatedUser) {
        return teacherDao.updateTeacher(id, updatedUser);
    }

    @Override
    public Teacher addStudent(Integer studentId, Integer teacherId) {

        return teacherDao.addStudent(studentId, teacherId);
    }
}