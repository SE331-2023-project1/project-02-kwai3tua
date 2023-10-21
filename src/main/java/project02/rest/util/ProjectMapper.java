package project02.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project02.rest.entity.Student;
import project02.rest.entity.StudentDTO;

import java.util.List;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    StudentDTO getStudentDto(Student student);
    List<StudentDTO> getStudentDto(List<Student> students);
}
