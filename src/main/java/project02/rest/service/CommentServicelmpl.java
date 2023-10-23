package project02.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project02.rest.entity.Comment;
import project02.rest.entity.Student;
import project02.rest.entity.Teacher;
import project02.rest.repository.CommentRepository;
import project02.rest.repository.StudentRepository;
import project02.rest.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServicelmpl implements CommentService{

    private CommentRepository commentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Comment createComment(Long studentId, Long teacherId, String content) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);
        // use StudentId as a target to post by and searching for
        // use TeacherId as a author

        if (studentOpt.isPresent() && teacherOpt.isPresent()) {
            Comment comment = Comment.builder()
                    .content(content)
                    .student(studentOpt.get())
                    .teacher(teacherOpt.get())
                    .build();

            return commentRepository.save(comment);
        }

        return null;
    }

    @Override
    public Comment replyComment(Long studentId, Long teacherId,Long commentId, String content) {
        Comment parentComment = commentRepository.findById(commentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Comment not found with ID: " + commentId));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found with ID: " + studentId));
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Teacher not found with ID: " + teacherId));


        if (student != null) {
            Comment reply = new Comment();
            reply.setContent(content);
            reply.setParentComment(parentComment);
            reply.setStudent(student);
            reply.setTeacher(teacher);
            return commentRepository.save(reply);
        } else {
            return null;
        }
    }


    @Override
    public List<Comment> getAllCommentsByStudentId(Long studentId) {
        return commentRepository.findAllByStudentId(studentId);
    }
}
