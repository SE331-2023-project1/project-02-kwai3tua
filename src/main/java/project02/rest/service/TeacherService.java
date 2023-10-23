package project02.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Teacher;
import project02.rest.security.user.User;

import java.util.List;

public interface TeacherService {
    Integer getTeachersSize();

    List<Teacher> getTeachers(Integer pageSize, Integer page);

    Page<Teacher> getTeachers(String title, Pageable pageable);

    Teacher getTeacher(Long id);

    Teacher save(Teacher teacher);

    User updateTeacher(Long id, User updatedUser, MultipartFile imageFile);
}
