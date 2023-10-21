package project02.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project02.rest.entity.Student;

import project02.rest.service.StudentService;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
//    Path of website
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit",required = false)Integer perPage,
                                             @RequestParam(value = "_page",required = false)Integer page){
        Page<Student> pageOutput = studentService.getStudents(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        // indexOutOfBoundException
            return new
                    ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long studentId) {
        Student output = studentService.getStudent(studentId);
        if (output != null) {
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent (@RequestBody Student student){
        Student output = studentService.save(student);
        return ResponseEntity.ok(output);
    }
}


