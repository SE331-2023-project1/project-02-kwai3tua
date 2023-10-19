package project02.rest.service;

import project02.rest.event.Student;

import java.util.List;

public interface StudentService {
    Integer getStudentSize();
    List<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long studentId);
}
