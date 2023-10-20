package project02.rest.dao;

import project02.rest.event.Student;
import org.springframework.data.domain.Page;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long studentId);
}
