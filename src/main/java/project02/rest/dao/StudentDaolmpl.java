package project02.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import project02.rest.event.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class StudentDaolmpl implements StudentDao {
    List<Student> studentList;
    @Override
    public Integer getStudentSize(){
        return studentList.size();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? studentList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Student>(studentList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,pageSize),studentList.size());
    }

    @Override
    public Student getStudent(Long studentId) {
        return studentList.stream().filter(student ->
                student.getStudentId().equals(studentId)).findFirst().orElse(null);
    }

    @Override
    public Student save(Student student) {
        student.setStudentId(studentList.get(studentList.size()-1).getStudentId()+1);
        studentList.add(student);
        return student;
    }
}
