package project02.rest.dao;


import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import project02.rest.entity.Teacher;

import java.util.List;

@Repository
@Profile("manual")
public class TeacherDaolmpl implements TeacherDao {

    List<Teacher> teacherList;
    @Override
    public Integer getTeacherSize() {
        return teacherList.size();
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? teacherList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Teacher>(teacherList.subList(firstIndex,firstIndex+pageSize), PageRequest.of(page,pageSize),teacherList.size());
    }

    @Override
    public Teacher getTeacher(Long Id) {
        return teacherList.stream().filter(teacher ->
                teacher.getId().equals(Id)).findFirst().orElse(null);
    }

    @Override
    public Teacher save(Teacher teacher) {
        teacher.setId(teacherList.get(teacherList.size()-1).getId()+1);
        teacherList.add(teacher);
        return teacher;
    }
}
