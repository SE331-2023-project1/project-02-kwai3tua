package project02.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import project02.rest.event.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();
}

