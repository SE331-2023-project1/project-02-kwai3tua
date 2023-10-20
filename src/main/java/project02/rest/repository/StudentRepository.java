package project02.rest.repository;

import org.springframework.data.repository.CrudRepository;
import project02.rest.event.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findAll();
}

