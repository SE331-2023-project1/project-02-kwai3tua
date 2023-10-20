package project02.rest.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import project02.rest.event.Student;
import project02.rest.repository.StudentRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final StudentRepository studentRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        studentRepository.save(Student.builder()
                .studentId(642115023L)
                .name("Sukalee")
                .surname("Seema")
                .profileImg("Profile")
                .department("SE")
                .build());
    }
}
