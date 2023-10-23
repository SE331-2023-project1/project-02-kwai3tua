package com.se331.kwai3tua.repository;

import com.se331.kwai3tua.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByStudentId(Long studentId);
    List<Comment> findByStudentIdAndParentCommentIsNull(Long studentId);
    List<Comment> findByStudentId(Long studentId);
    Comment findByParentCommentId(Long id);
}