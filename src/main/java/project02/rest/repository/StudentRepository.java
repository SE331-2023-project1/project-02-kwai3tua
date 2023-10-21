package project02.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project02.rest.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();
}

