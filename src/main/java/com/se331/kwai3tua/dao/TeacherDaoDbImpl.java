package com.se331.kwai3tua.dao;

import com.se331.kwai3tua.entity.Student;
import com.se331.kwai3tua.entity.Teacher;
import com.se331.kwai3tua.repository.StudentRepository;
import com.se331.kwai3tua.repository.TeacherRepository;
import com.se331.kwai3tua.security.user.User;
import com.se331.kwai3tua.security.user.UserRepository;
import com.se331.kwai3tua.util.CloudStorageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class TeacherDaoDbImpl implements TeacherDao {
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;
    final StudentRepository studentRepository;

    @Autowired
    private CloudStorageHelper cloudStorageHelper;

    @Override
    public Integer getTeacherSize() {
        return Math.toIntExact(teacherRepository.count());
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Teacher> getTeachers(String filter, Pageable page) {
        return teacherRepository.findByUser_FirstnameIgnoreCaseContainingOrUser_LastnameIgnoreCaseContainingOrUser_UsernameIgnoreCaseContaining(filter,filter,filter, page);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public User updateTeacher(Long id, User updatedUser) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    User user = teacher.getUser();
                    if (updatedUser.getFirstname() != null) {
                        user.setFirstname(updatedUser.getFirstname());
                    }
                    if (updatedUser.getLastname() != null) {
                        user.setLastname(updatedUser.getLastname());
                    }
                    if (updatedUser.getUsername() != null) {
                        user.setUsername(updatedUser.getUsername());
                    }
                    if (updatedUser.getEmail() != null) {
                        user.setEmail(updatedUser.getEmail());
                    }
                    if (updatedUser.getPassword() != null) {
                        user.setPassword(updatedUser.getPassword());
                    }
                    if (updatedUser.getImage() != null) {
                        user.setImage(updatedUser.getImage());
                    }
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @Override
    public Teacher addStudent(Integer studentId, Integer teacherId) {
        Optional<Student> student = studentRepository.findById(studentId.longValue());
        Optional<Teacher> teacher = teacherRepository.findById(teacherId.longValue());
        if(student.isPresent() && teacher.isPresent()) {
            Student student_pre = student.get();
            Teacher teacher_pre = teacher.get();

            student_pre.setTeacher(teacher_pre);
            teacher_pre.getOwnStudent().add(student_pre);
            studentRepository.save(student_pre);
            teacherRepository.save(teacher_pre);
            return teacher_pre;
        }
        return null;
    }
}