package project02.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import project02.rest.event.Teacher;
import project02.rest.repository.TeacherRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class TeacherDaoDblmpl implements TeacherDao {

    final TeacherRepository teacherRepository;

    @Override
    public Integer getTeacherSize() {
        return Math.toIntExact(teacherRepository.count());
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Teacher getTeacher(Long Id) {
        return teacherRepository.findById(Id).orElse(null);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
