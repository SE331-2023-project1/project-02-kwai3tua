package project02.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import project02.rest.entity.Teacher;
import project02.rest.repository.TeacherRepository;
import project02.rest.security.user.User;
import project02.rest.service.TeacherService;
import project02.rest.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TeacherController {
    final TeacherService teacherService;
    final TeacherRepository teacherRepository;
    @GetMapping("/teachers")
    public ResponseEntity<?> getAllTeachers(@RequestParam(value = "_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "_filter", required = false) String filter) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        List<Teacher> pageOutput;
        pageOutput = teacherRepository.findAll();
        return ResponseEntity.ok(pageOutput.stream().map(LabMapper.INSTANCE::getDetailedTeacherDTO));


    }

    @GetMapping("/teachers/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getTeacherById(@PathVariable("id") Long id) {
        Teacher teacherOpt = teacherService.getTeacher(id);
        if (teacherOpt != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(teacherOpt));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/teachers")
    public ResponseEntity<?> addTeacher (@RequestBody Teacher teacher){
        Teacher output = teacherService.save(teacher);
        return ResponseEntity.ok(output);
    }

    @PutMapping(value = "/teachers/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> updateTeacher(@PathVariable("id") Long id,
                                           @ModelAttribute User user,
                                           @RequestPart("images") MultipartFile imageFile) {
        User updatedUser = teacherService.updateTeacher(id, user, imageFile);
        if (updatedUser != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(updatedUser));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
}
