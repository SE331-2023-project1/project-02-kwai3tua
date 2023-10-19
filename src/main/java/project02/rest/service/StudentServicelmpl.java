package project02.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project02.rest.dao.StudentDao;
import project02.rest.event.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServicelmpl implements StudentService {

    final StudentDao studentDao;
    @Override
    public Integer getStudentSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public List<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize,page);
    }

    @Override
    public Student getStudent(Long studentId) {
        return studentDao.getStudent(studentId);
    }
}
