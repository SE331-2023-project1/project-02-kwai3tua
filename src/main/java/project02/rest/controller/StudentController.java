package project02.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project02.rest.entity.Student;

import project02.rest.repository.StudentRepository;
import project02.rest.service.StudentService;
import project02.rest.util.ProjectMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    final StudentRepository studentRepository;
//    Path of website
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit",required = false)Integer perPage,
                                             @RequestParam(value = "_page",required = false)Integer page,
                                             @RequestParam(value = "firstname", required = false) String firstname){
        perPage = perPage == null ? 20 : perPage;
        page = page == null ? 1 : page;
        List<Student> pageOutput;

        pageOutput = studentRepository.findAll();

        return ResponseEntity.ok(ProjectMapper.INSTANCE.getStudentDto(pageOutput));
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        Student output = studentService.getStudent(id);
        if (output != null) {
            return ResponseEntity.ok(ProjectMapper.INSTANCE.getStudentDto(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent (@RequestBody Student student){
        Student output = studentService.save(student);
        return ResponseEntity.ok(ProjectMapper.INSTANCE.getStudentDto(output));
    }
}


