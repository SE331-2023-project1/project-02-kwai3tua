package project02.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import project02.rest.entity.Student;

import project02.rest.repository.StudentRepository;
import project02.rest.security.user.User;
import project02.rest.security.user.UserRepository;
import project02.rest.security.user.UserService;
import project02.rest.service.StudentService;
import project02.rest.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    final StudentRepository studentRepository;
    final UserRepository userRepository;
    final UserService userService;
//    Path of website

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(users));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(user));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


    @GetMapping("students")
    public ResponseEntity<?> getAllStudents(@RequestParam(value = "_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "_filter", required = false) String filter) {
        perPage = perPage == null ? 20 : perPage;
        page = page == null ? 1 : page;
        List<Student> pageOutput;

        pageOutput = studentRepository.findAll();

        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(pageOutput));

    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        Student studentopt = studentService.getStudent(id);
        if (studentopt != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(studentopt));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    //To Update Student
    @PutMapping(value = "/students/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id,
                                           @ModelAttribute User user,
                                           @RequestPart("images") MultipartFile imageFile) {
        User output = studentService.updateStudent(id, user, imageFile);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
}


