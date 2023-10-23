package project02.rest.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Student;
import org.springframework.data.domain.Page;
import project02.rest.security.user.User;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> findByUser_Firstname(String firstname, Pageable page);
    Student getStudent(Long studentId);

    Student save(Student student);
    User updateStudent(Long id, User updatedUser, MultipartFile imageFile);
}
