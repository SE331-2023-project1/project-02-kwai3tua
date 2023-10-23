package project02.rest.service;

import org.springframework.stereotype.Service;
import project02.rest.entity.Comment;

import java.util.List;

@Service
public interface CommentService {
    Comment createComment(Long studentId, Long teacherId, String content);
    Comment replyComment(Long studentId, Long teacherId,Long commentId, String content);
    List<Comment> getAllCommentsByStudentId(Long studentId);
}
