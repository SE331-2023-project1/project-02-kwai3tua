package project02.rest.config;


import jakarta.transaction.Transactional;
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
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Teacher t1,t2;
        t1 = teacherRepository.save(Teacher.builder()
                .department("SE")
                .username("test1")
                .password("password")
                .position("Professor")
                .profileImg("img")
                .name("kru")
                .surname("wai")
                .build());
        t2 = teacherRepository.save(Teacher.builder()
                .department("SE")
                .username("test2")
                .password("password")
                .position("Professor")
                .profileImg("img")
                .name("kru2")
                .surname("wai2")
                .build());

        Student tempStudent1,tempStudent2,tempStudent3;
        tempStudent1 = studentRepository.save(Student.builder()
                .studentId(642115038L)
                .name("Yotsawat")
                .surname("Lekwongthanasin")
                .department("SE")
                .profileImg("img")
                .build());
        tempStudent2 = studentRepository.save(Student.builder()
                .studentId(642115008L)
                .name("Jirapat")
                .surname("Namwong")
                .department("SE")
                .profileImg("img")
                .build());
        tempStudent3 = studentRepository.save(Student.builder()
                .studentId(642115036L)
                .name("Putthipong")
                .surname("Nimwong")
                .department("SE")
                .profileImg("img")
                .build());
        tempStudent1.setAdvisor(t1);
        tempStudent2.setAdvisor(t2);
        tempStudent3.setAdvisor(t1);
        t1.getAdvisee().add(tempStudent1);
        t2.getAdvisee().add(tempStudent2);
        t1.getAdvisee().add(tempStudent3);
    }
}
