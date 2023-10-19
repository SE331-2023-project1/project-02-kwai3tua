package project02.rest.dao;

import project02.rest.event.Student;

import java.util.List;

public interface StudentDao {
    Integer getStudentSize();
    List<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long studentId);
}
