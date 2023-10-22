package project02.rest.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project02.rest.entity.Student;
import project02.rest.entity.Teacher;
import project02.rest.repository.StudentRepository;
import project02.rest.repository.TeacherRepository;
import project02.rest.security.user.Role;
import project02.rest.security.user.User;
import project02.rest.security.user.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {

        User admin = new User();
        admin.setUsername("admin");
        admin.setFirstname("admin");
        admin.setLastname("admin");
        admin.setPassword(encoder.encode("admin"));
        admin.setEmail("admin@admin.com");
        admin.setRoles(List.of(Role.ROLE_ADMIN));
        userRepository.save(admin);


        User userT1 = new User();
        userT1.setUsername("floky");
        userT1.setFirstname("floky");
        userT1.setLastname("faze");
        userT1.setPassword("password");
        userT1.setEmail("floky@email.com");
        userT1.setRoles(List.of(Role.ROLE_TEACHER));
        userT1.setProfileImg("");
        userRepository.save(userT1);


        User userT2 = new User();
        userT2.setUsername("simple");
        userT2.setFirstname("simple");
        userT2.setLastname("navi");
        userT2.setPassword("simpleed");
        userT2.setEmail("simple@navi.com");
        userT2.setRoles(List.of(Role.ROLE_TEACHER));
        userT2.setProfileImg("");
        userRepository.save(userT2);

        User userS1 = new User();
        userS1.setUsername("niko");
        userS1.setFirstname("Niko");
        userS1.setLastname("Gtwo");
        userS1.setEmail("niko@gtwo.com");
        userS1.setPassword("nikogod");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setProfileImg("");
        userRepository.save(userS1);

        User userS2 = new User();
        userS2.setUsername("qqgod");
        userS2.setFirstname("Aomsin");
        userS2.setLastname("Nkt");
        userS2.setPassword("qqgod");
        userS2.setEmail("qq@god.com");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setProfileImg("");
        userRepository.save(userS2);

        User userS3 = new User();
        userS3.setUsername("ciggod");
        userS3.setFirstname("Pathipan");
        userS3.setLastname("Posri");
        userS3.setPassword("cigmith");
        userS3.setEmail("cig@god.com");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setProfileImg("");
        userRepository.save(userS3);

        User userS4 = new User();
        userS4.setUsername("notail");
        userS4.setFirstname("Daddy");
        userS4.setLastname("Notail");
        userS4.setPassword("ogCEO");
        userS4.setEmail("notail@og.com");
        userS4.setRoles(List.of(Role.ROLE_STUDENT));
        userS4.setProfileImg("");
        userRepository.save(userS4);

        User userS5 = new User();
        userS5.setUsername("topson");
        userS5.setFirstname("Dadson");
        userS5.setLastname("Trunda");
        userS5.setPassword("dogson");
        userS5.setEmail("topson@trunda.com");
        userS5.setRoles(List.of(Role.ROLE_STUDENT));
        userS5.setProfileImg("");
        userRepository.save(userS5);

        User userS6 = new User();
        userS6.setUsername("ana");
        userS6.setFirstname("Anana");
        userS6.setLastname("Pham");
        userS6.setPassword("carrygod");
        userS6.setEmail("ana@humlek.com");
        userS6.setRoles(List.of(Role.ROLE_STUDENT));
        userS6.setProfileImg("");
        userRepository.save(userS6);

        User userS7 = new User();
        userS7.setUsername("Forsaken");
        userS7.setFirstname("Konthai");
        userS7.setLastname("Naisingapore");
        userS7.setPassword("RakPgra");
        userS7.setEmail("jason@susanto.com");
        userS7.setRoles(List.of(Role.ROLE_STUDENT));
        userS7.setProfileImg("");
        userRepository.save(userS7);

        User userS8 = new User();
        userS8.setUsername("hrkwannabe");
        userS8.setFirstname("Aek");
        userS8.setLastname("Taupom");
        userS8.setPassword("hrkzaza");
        userS8.setEmail("hrk@taupom.com");
        userS8.setRoles(List.of(Role.ROLE_STUDENT));
        userS8.setProfileImg("");
        userRepository.save(userS8);

        User userS9 = new User();
        userS9.setUsername("beatigirl");
        userS9.setFirstname("Konsuay");
        userS9.setLastname("Mehum");
        userS9.setPassword("ladyboy");
        userS9.setEmail("samak@kom.com");
        userS9.setRoles(List.of(Role.ROLE_STUDENT));
        userS9.setProfileImg("");
        userRepository.save(userS9);

        User userS10 = new User();
        userS10.setUsername("Hothothot");
        userS10.setFirstname("Lotto");
        userS10.setLastname("Parker");
        userS10.setPassword("lucky888");
        userS10.setEmail("lotto@gg.com");
        userS10.setRoles(List.of(Role.ROLE_STUDENT));
        userS10.setProfileImg("");
        userRepository.save(userS10);


        Student s1 = new Student();
        s1.setUser(userS1);


        Teacher t1 = new Teacher();
        t1.setUser(userT1);
        s1.setAdvisor(t1);
        t1.getAdvisee().add(s1);
        teacherRepository.save(t1);
        studentRepository.save(s1);


//        Student s2 = new Student();
//        s1.setUser(userS2);
//        s1.setAdvisor(t1);
//        studentRepository.save(s2);
//        Student s3 = new Student();
//        s1.setUser(userS3);
//        s1.setAdvisor(t1);
//        studentRepository.save(s3);
//        Student s4 = new Student();
//        s1.setUser(userS4);
//        s1.setAdvisor(t1);
//        studentRepository.save(s4);
//        Student s5 = new Student();
//        s1.setUser(userS5);
//        s1.setAdvisor(t1);
//        studentRepository.save(s5);
//
//
//        Teacher t2 = new Teacher();
//        t2.setUser(userT2);
//        teacherRepository.save(t2);
//        Student s6 = new Student();
//        s1.setUser(userS6);
//        s1.setAdvisor(t2);
//        studentRepository.save(s6);
//        Student s7 = new Student();
//        s1.setUser(userS7);
//        s1.setAdvisor(t2);
//        studentRepository.save(s7);
//        Student s8 = new Student();
//        s1.setUser(userS8);
//        s1.setAdvisor(t2);
//        studentRepository.save(s8);
//        Student s9 = new Student();
//        s1.setUser(userS9);
//        s1.setAdvisor(t2);
//        studentRepository.save(s9);
//        Student s10 = new Student();
//        s1.setUser(userS10);
//        s1.setAdvisor(t2);
//        studentRepository.save(s10);
    }
}
