package project02.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Teacher;
import project02.rest.security.user.User;

import java.util.List;

public interface TeacherDao {
    Integer getTeacherSize();
    Teacher save(Teacher teacher);
    List<Teacher> getTeachers(Integer pageSize, Integer page);
    Page<Teacher> getTeachers(String name, Pageable page);
    Teacher getTeacher(Long id);

    User updateTeacher(Long id, User updatedUser, MultipartFile imageFile);
}
