package project02.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project02.rest.entity.Student;
import project02.rest.entity.StudentDTO;
import project02.rest.entity.Teacher;
import project02.rest.entity.TeacherDTO;

import java.util.List;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    StudentDTO getStudentDto(Student student);
    List<StudentDTO> getStudentDto(List<Student> students);
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
}
