package project02.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Teacher;
import project02.rest.security.user.User;

public interface TeacherService {
    Integer getTeacherSize();
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Teacher getTeacher(Long Id);
    Teacher save(Teacher teacher);
    User updateTeacher(Long id, User user, MultipartFile imageFile);
}
