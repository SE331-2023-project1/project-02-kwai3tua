package com.se331.kwai3tua.service;

import com.se331.kwai3tua.entity.Comment;
import com.se331.kwai3tua.entity.Student;
import com.se331.kwai3tua.entity.Teacher;
import com.se331.kwai3tua.exception.ResourceNotFoundException;
import com.se331.kwai3tua.repository.CommentRepository;
import com.se331.kwai3tua.repository.StudentRepository;
import com.se331.kwai3tua.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Comment createComment(Long studentId, Long teacherId, String content) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);
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
        Comment parentComment = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment not found with ID: " + commentId));
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + studentId));
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher not found with ID: " + teacherId));
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