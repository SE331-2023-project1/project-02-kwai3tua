package project02.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import project02.rest.dao.TeacherDao;
import project02.rest.entity.Teacher;

@Service
@RequiredArgsConstructor
public class TeacherServicelmpl implements TeacherService{
    final TeacherDao teacherDao;
    @Override
    public Integer getTeacherSize() {
        return teacherDao.getTeacherSize();
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherDao.getTeachers(pageSize, page);
    }

    @Override
    public Teacher getTeacher(Long Id) {
        return teacherDao.getTeacher(Id);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }
}
