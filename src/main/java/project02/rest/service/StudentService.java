package project02.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Student;
import project02.rest.security.user.User;

public interface StudentService {
    Integer getStudentsSize();

    Page<Student> getStudents(Integer pageSize, Integer page);

    Page<Student> getStudents(String filter, Pageable pageable);

    Student getStudent(Long id);

    Student save(Student student);

    User updateStudent(Long id, User user, MultipartFile image );

    User findUserByStudentId(Long studentUserId);
}
