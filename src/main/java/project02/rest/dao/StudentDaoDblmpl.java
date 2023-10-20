package project02.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import project02.rest.event.Student;
import project02.rest.repository.StudentRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDblmpl implements StudentDao {

    final StudentRepository studentRepository;
    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public List<Student> getStudents(Integer pageSize, Integer page) {
        List<Student> students = studentRepository.findAll();
           pageSize = pageSize == null ? students.size() : pageSize;
           page = page == null ? 1 : page;
           int firstIndex = (page - 1) * pageSize;
           List<Student> output = students.subList(firstIndex, firstIndex + pageSize);
           return output;
    }

    @Override
    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
}
