package com.se331.kwai3tua.dao;

import com.se331.kwai3tua.entity.Student;
import com.se331.kwai3tua.repository.StudentRepository;
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

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDbImpl implements StudentDao {
    final StudentRepository studentRepository;
    final UserRepository userRepository;

    @Autowired
    private CloudStorageHelper cloudStorageHelper;

    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Student> getStudents(String filter, Pageable page) {
        return studentRepository.findByUser_FirstnameIgnoreCaseContainingOrUser_LastnameIgnoreCaseContainingOrUser_UsernameIgnoreCaseContaining(filter,filter,filter, page);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public User updateStudent(Long id, User updatedUser) {
        return studentRepository.findById(id)
                .map(student -> {
                    User user = student.getUser();
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
}