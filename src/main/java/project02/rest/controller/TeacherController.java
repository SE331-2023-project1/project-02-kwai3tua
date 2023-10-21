package project02.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import project02.rest.entity.Teacher;
import project02.rest.service.TeacherService;

@Controller
@RequiredArgsConstructor
public class TeacherController {
    final TeacherService teacherService;
    @GetMapping("teachers")
    public ResponseEntity<?> getTeacherLists(@RequestParam(value = "_limit",required = false)Integer perPage,
                                             @RequestParam(value = "_page",required = false)Integer page){
        Page<Teacher> pageOutput = teacherService.getTeachers(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",String.valueOf(pageOutput.getTotalElements()));
        // indexOutOfBoundException
        return new
                ResponseEntity<>(pageOutput.getContent(),responseHeader, HttpStatus.OK);
    }

    @GetMapping("teachers/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long Id) {
        Teacher output = teacherService.getTeacher(Id);
        if (output != null) {
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/teachers")
    public ResponseEntity<?> addStudent (@RequestBody Teacher teacher){
        Teacher output = teacherService.save(teacher);
        return ResponseEntity.ok(output);
    }
}
