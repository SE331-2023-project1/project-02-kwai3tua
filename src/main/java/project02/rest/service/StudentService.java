package project02.rest.service;

import org.springframework.data.domain.Page;
import project02.rest.entity.Student;

public interface StudentService {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long studentId);
    Student save(Student student);
}
