package project02.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.dao.StudentDao;
import project02.rest.entity.Student;
import project02.rest.security.user.User;

@Service
@RequiredArgsConstructor
public class StudentServicelmpl implements StudentService {

    final StudentDao studentDao;
    @Override
    public Integer getStudentSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize,page);
    }

    @Override
    public Page<Student> getStudentByFirstname(String firstname, Pageable pageable) {
        return studentDao.findByUser_Firstname(firstname, pageable);
    }

    @Override
    public Student getStudent(Long studentId) {
        return studentDao.getStudent(studentId);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public User updateStudent(Long id, User user, MultipartFile image) {
        return studentDao.updateStudent(id, user, image);
    }
}
