package project02.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project02.rest.entity.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAll();
    Page<Teacher> findByUser_FirstnameOrUser_LastnameOrUser_Username(String firstname, String lastname, String username, Pageable pageRequest);
}
