package project02.rest.service;

import org.springframework.data.domain.Page;
import project02.rest.entity.Teacher;

public interface TeacherService {
    Integer getTeacherSize();
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Teacher getTeacher(Long Id);
    Teacher save(Teacher teacher);
}
