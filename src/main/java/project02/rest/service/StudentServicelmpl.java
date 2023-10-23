package project02.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.dao.StudentDao;
import project02.rest.entity.Student;
import project02.rest.repository.StudentRepository;
import project02.rest.security.user.User;

@Service
@RequiredArgsConstructor
public class StudentServicelmpl implements StudentService {

    final StudentDao studentDao;
    private final StudentRepository studentRepository;
    @Override
    public Integer getStudentsSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }

    @Override
    public Page<Student> getStudents(String filter, Pageable pageable) {
        return studentDao.getStudents(filter,pageable);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public User updateStudent(Long id, User user, MultipartFile image) {
        return studentDao.updateStudent(id, user, image);
    }

    @Override
    public User findUserByStudentId(Long studentId) {
        return studentRepository.findById(studentId)
                .map(Student::getUser)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }
}
