package project02.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project02.rest.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>  {
        List<Comment> findAllByStudentId(Long studentId);

        List<Comment> findByStudentIdAndParentCommentIsNull(Long studentId);

        List<Comment> findByStudentId(Long studentId);

        Comment findByParentCommentId(Long id);

}
