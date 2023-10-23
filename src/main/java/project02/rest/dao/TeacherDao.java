package project02.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Teacher;
import project02.rest.security.user.User;

public interface TeacherDao {
    Integer getTeacherSize();
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Teacher getTeacher(Long Id);
    Teacher save(Teacher teacher);
    User updateTeacher(Long id, User updatedUser, MultipartFile imageFile);
}
