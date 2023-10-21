package project02.rest.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import project02.rest.entity.Student;
import project02.rest.entity.Teacher;
import project02.rest.repository.StudentRepository;
import project02.rest.repository.TeacherRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        studentRepository.save(Student.builder()
                .studentId(642115023L)
                .name("Sukalee")
                .surname("Seema")
                .profileImg("Profile")
                .department("SE")
                .build());
        teacherRepository.save(Teacher.builder()
                .name("Test")
                .surname("Manek")
                .position("brabra")
                .profileImg("img")
                .department("SE")
                .username("test")
                .password("1234")
                .advisee("Yotsawat")
                .build());
    }
}
