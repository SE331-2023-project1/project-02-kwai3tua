package project02.rest.util;

import project02.rest.entity.*;
import project02.rest.security.user.User;
import project02.rest.security.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import project02.rest.entity.Student;
import project02.rest.entity.StudentDTO;
import project02.rest.entity.Teacher;
import project02.rest.entity.TeacherDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    List<StudentDTO> getStudentDTO(List<Student> students);
//    @Mapping(source = "user.id", target = "id")
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
    UserDTO getUserDTO(User user);
    List<UserDTO> getUserDTO(List<User> users);

    AnnouncementDTO getAnnouncementDTO(User user);

    List<AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcements);

//    @Mapping(source = "user.id", target = "id")
@Mapping(source = "user.username", target = "username")
@Mapping(source = "user.firstname", target = "firstname")
@Mapping(source = "user.lastname", target = "lastname")
@Mapping(source = "user.email", target = "email")
@Mapping(source = "user.roles", target = "roles")
@Mapping(source = "user.image", target = "image")
@Mapping(source = "ownStudent", target = "ownStudent")
DetailedTeacherDTO getDetailedTeacherDTO(Teacher teacher);


    @Mapping(source = "user.firstname", target = "name")
    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.lastname", target = "surname")
    @Mapping(source = "user.image", target = "image")
    @Mapping(source = "user.email", target = "email")
    TeacherOwnStudentDTO getTeacherOwnStudentDTO(Student student);

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "firstname")
    @Mapping(source = "user.lastname", target = "lastname")
    @Mapping(source = "user.image", target = "image")
    TeacherBriefDTO getTeacherBriefDTO(Teacher teacher);

    @Mapping(source = "teacher", target = "teacher")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.firstname", target = "firstname")
    @Mapping(source = "user.lastname", target = "lastname")
//    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "user.image", target = "image")
    @Mapping(source = "user.email", target = "email")
    StudentDTO getStudentDTO(Student student);

    AnnouncementDTO getAnnouncementDTO(Announcement announcement);

    @Mapping(source = "student.id", target = "studentId")
    @Mapping(source = "teacher.id", target = "teacherId")
    CommentDTO commentToCommentDTO(Comment comment);
//    CommentDTO commentToCommentDTO(Comment comment);

    default CommentDTO replyToCommentDTO(Comment comment) {
        if (comment == null) return null;
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .studentId(comment.getStudent().getId())
                .teacherId(comment.getTeacher() != null ? comment.getTeacher().getId() : null)
                .build();
    }


}
