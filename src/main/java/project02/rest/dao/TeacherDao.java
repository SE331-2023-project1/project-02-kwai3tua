package project02.rest.dao;

import org.springframework.data.domain.Page;
import project02.rest.event.Teacher;

public interface TeacherDao {
    Integer getTeacherSize();
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Teacher getTeacher(Long Id);
    Teacher save(Teacher teacher);
}
