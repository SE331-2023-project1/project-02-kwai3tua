package com.se331.kwai3tua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.se331.kwai3tua.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    Page<Student> findByUser_FirstnameIgnoreCaseContainingOrUser_LastnameIgnoreCaseContainingOrUser_UsernameIgnoreCaseContaining(String firstname, String lastname, String username, Pageable pageRequest);
    Page<Student> findAllByTeacherIsNull(Pageable pageable);
    Page<Student> findById(Long id,Pageable pageable);
    Page<Student> findByTeacherIsNull(Pageable pageable);
}
