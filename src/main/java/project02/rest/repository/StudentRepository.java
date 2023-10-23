package project02.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import project02.rest.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();
    Page<Student> findByUser_FirstnameOrUser_LastnameOrUser_Username(String firstname, String lastname, String username, Pageable pageRequest);
}

