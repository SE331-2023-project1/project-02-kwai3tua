package com.se331.kwai3tua.config;

import com.se331.kwai3tua.entity.Student;
import com.se331.kwai3tua.entity.Teacher;
import com.se331.kwai3tua.repository.StudentRepository;
import com.se331.kwai3tua.repository.TeacherRepository;
import com.se331.kwai3tua.security.user.Role;
import com.se331.kwai3tua.security.user.User;
import com.se331.kwai3tua.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        User admin = new User();
        admin.setUsername("admin");
        admin.setFirstname("admin");
        admin.setLastname("admin");
        admin.setPassword(encoder.encode("admin"));
        admin.setEmail("admin@admin.com");
        admin.setRoles(List.of(Role.ROLE_ADMIN));
        userRepository.save(admin);

        User userT1 = new User();
        userT1.setUsername("teacher1");
        userT1.setFirstname("FaZe");
        userT1.setLastname("Broky");
        userT1.setPassword(encoder.encode("753951"));
        userT1.setEmail("teacher1@gmail.com");
        userT1.setRoles(List.of(Role.ROLE_TEACHER));
        userT1.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160516296-borky.jpg?generation=1698051916574394&alt=media");
        userRepository.save(userT1);

        User userT2 = new User();
        userT2.setUsername("teacher2");
        userT2.setFirstname("NaVi");
        userT2.setLastname("S1mple");
        userT2.setPassword(encoder.encode("753951"));
        userT2.setEmail("teacher2@hotmail.com");
        userT2.setRoles(List.of(Role.ROLE_TEACHER));
        userT2.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160516068-Simple.png?generation=1698051916410803&alt=media");
        userRepository.save(userT2);

        User userT3 = new User();
        userT3.setUsername("teacher3");
        userT3.setFirstname("Nikolas");
        userT3.setLastname("Niko");
        userT3.setEmail("teacher3@outlook.com");
        userT3.setPassword(encoder.encode("753951"));
        userT3.setRoles(List.of(Role.ROLE_TEACHER));
        userT3.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160515877-Niko.png?generation=1698051916174669&alt=media");
        userRepository.save(userT3);

        User userT4 = new User();
        userT4.setUsername("teacher4");
        userT4.setFirstname("NKT");
        userT4.setLastname("qqGOD");
        userT4.setEmail("teacher4@gmail.com");
        userT4.setPassword(encoder.encode("753951"));
        userT4.setRoles(List.of(Role.ROLE_TEACHER));
        userT4.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160515424-qqGOD.png?generation=1698051915984598&alt=media");
        userRepository.save(userT4);

        User userT5 = new User();
        userT5.setUsername("teacher5");
        userT5.setFirstname("MiTH");
        userT5.setLastname("Cigarettes");
        userT5.setEmail("teacher1@hotmail.co.th");
        userT5.setPassword(encoder.encode("753951"));
        userT5.setRoles(List.of(Role.ROLE_TEACHER));
        userT5.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514931-CigaretteS.jpg?generation=1698051915464741&alt=media");
        userRepository.save(userT5);

        User userS1 = new User();
        userS1.setUsername("student1");
        userS1.setFirstname("OG");
        userS1.setLastname("N0tail");
        userS1.setEmail("student1@outlook.com");
        userS1.setPassword(encoder.encode("753951"));
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514648-Notail.jpg?generation=1698051914985930&alt=media");
        userRepository.save(userS1);

        User userS2 = new User();
        userS2.setUsername("student2");
        userS2.setFirstname("Tundra");
        userS2.setLastname("Topson");
        userS2.setPassword(encoder.encode("753951"));
        userS2.setEmail("student2@gmail.com");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514250-Topson.jpeg?generation=1698051914721319&alt=media");
        userRepository.save(userS2);

        User userS3 = new User();
        userS3.setUsername("student3");
        userS3.setFirstname("T1");
        userS3.setLastname("Ana");
        userS3.setPassword(encoder.encode("753951"));
        userS3.setEmail("student3@hotmail.com");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514086-Ana.jpg?generation=1698051914357913&alt=media");
        userRepository.save(userS3);

        User userS4 = new User();
        userS4.setUsername("student4");
        userS4.setFirstname("Jason");
        userS4.setLastname("Forsaken");
        userS4.setPassword(encoder.encode("753951"));
        userS4.setEmail("student4@outlook.com");
        userS4.setRoles(List.of(Role.ROLE_STUDENT));
        userS4.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160513831-Jason.png?generation=1698051914185777&alt=media");
        userRepository.save(userS4);

        User userS5 = new User();
        userS5.setUsername("student5");
        userS5.setFirstname("Heart");
        userS5.setLastname("Rocker");
        userS5.setPassword(encoder.encode("753951"));
        userS5.setEmail("student5@gmail.com");
        userS5.setRoles(List.of(Role.ROLE_STUDENT));
        userS5.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160513625-hrk.jpg?generation=1698051913921112&alt=media");
        userRepository.save(userS5);

        User userS6 = new User();
        userS6.setUsername("student6");
        userS6.setFirstname("Putthipong");
        userS6.setLastname("Ninwong");
        userS6.setPassword(encoder.encode("753951"));
        userS6.setEmail("student6@hotmail.co.th");
        userS6.setRoles(List.of(Role.ROLE_STUDENT));
        userS6.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160512500-aek.jpg?generation=1698051913669997&alt=media");
        userRepository.save(userS6);

        User userS7 = new User();
        userS7.setUsername("student7");
        userS7.setFirstname("FaZe");
        userS7.setLastname("Niko");
        userS7.setPassword(encoder.encode("753951"));
        userS7.setEmail("student7@outlook.com");
        userS7.setRoles(List.of(Role.ROLE_STUDENT));
        userS7.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160515877-Niko.png?generation=1698051916174669&alt=media");
        userRepository.save(userS7);

        User userS8 = new User();
        userS8.setUsername("student8");
        userS8.setFirstname("Ana");
        userS8.setLastname("Topform");
        userS8.setPassword(encoder.encode("753951"));
        userS8.setEmail("student8@gmail.com");
        userS8.setRoles(List.of(Role.ROLE_STUDENT));
        userS8.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514086-Ana.jpg?generation=1698051914357913&alt=media");
        userRepository.save(userS8);

        User userS9 = new User();
        userS9.setUsername("student9");
        userS9.setFirstname("Patiphan");
        userS9.setLastname("Posri");
        userS9.setPassword(encoder.encode("753951"));
        userS9.setEmail("student9@hotmail.com");
        userS9.setRoles(List.of(Role.ROLE_STUDENT));
        userS9.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514931-CigaretteS.jpg?generation=1698051915464741&alt=media");
        userRepository.save(userS9);

        User userS10 = new User();
        userS10.setUsername("student10");
        userS10.setFirstname("Johan");
        userS10.setLastname("Sundstein");
        userS10.setPassword(encoder.encode("753951"));
        userS10.setEmail("student10@outlook.com");
        userS10.setRoles(List.of(Role.ROLE_STUDENT));
        userS10.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514648-Notail.jpg?generation=1698051914985930&alt=media");
        userRepository.save(userS10);

        User userS11 = new User();
        userS11.setUsername("student11");
        userS11.setFirstname("Oleksandr");
        userS11.setLastname("Kostyljev");
        userS11.setPassword(encoder.encode("753951"));
        userS11.setEmail("student11@gmail.com");
        userS11.setRoles(List.of(Role.ROLE_STUDENT));
        userS11.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160516068-Simple.png?generation=1698051916410803&alt=media");
        userRepository.save(userS11);

        User userS12 = new User();
        userS12.setUsername("student12");
        userS12.setFirstname("Jason");
        userS12.setLastname("Susanto");
        userS12.setPassword(encoder.encode("753951"));
        userS12.setEmail("student12@hotmail.co.th");
        userS12.setRoles(List.of(Role.ROLE_STUDENT));
        userS12.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160513831-Jason.png?generation=1698051914185777&alt=media");
        userRepository.save(userS12);


        Teacher t1 = new Teacher();
        t1.setUser(userT1);
        teacherRepository.save(t1);

        Student s1 = new Student();
        s1.setUser(userS1);
        s1.setTeacher(t1);
        studentRepository.save(s1);

        Teacher t4 = new Teacher();
        t4.setUser(userT4);
        t4.getOwnStudent().add(s1);
        s1.setTeacher(t4);
        teacherRepository.save(t4);
        studentRepository.save(s1);

        Teacher t5 = new Teacher();
        t5.setUser(userT5);

        Student s11 = new Student();
        s11.setUser(userS11);
        s11.setTeacher(t5);
        studentRepository.save(s11);
        t5.getOwnStudent().add(s11);
        teacherRepository.save(t5);

        Student s12 = new Student();
        s12.setUser(userS12);
        s12.setTeacher(t5);
        studentRepository.save(s12);
        t5.getOwnStudent().add(s12);
        teacherRepository.save(t5);

        Student s8 = new Student();
        s8.setUser(userS8);
        s8.setTeacher(t5);
        studentRepository.save(s8);
        t5.setUser(userT5);
        t5.getOwnStudent().add(s8);
        teacherRepository.save(t5);

        Student s9 = new Student();
        s9.setUser(userS9);
        s9.setTeacher(t4);
        studentRepository.save(s9);
        t4.getOwnStudent().add(s9);
        teacherRepository.save(t4);

        Student s10 = new Student();
        s10.setUser(userS10);
        s10.setTeacher(t5);
        studentRepository.save(s10);
        t5.getOwnStudent().add(s10);
        teacherRepository.save(t5);

        Teacher t2 = new Teacher();

        Student s2 = new Student();
        s2.setUser(userS2);
        s2.setTeacher(t2);
        studentRepository.save(s2);

        t2.setUser(userT2);
        t2.getOwnStudent().add(s2);
        s2.setTeacher(t2);
        teacherRepository.save(t2);
        studentRepository.save(s2);

        Teacher t3 = new Teacher();
        t3.setUser(userT3);
        teacherRepository.save(t3);

        Student s3 = new Student();
        s3.setUser(userS3);
        s3.setTeacher(t3);
        studentRepository.save(s3);

        t3.getOwnStudent().add(s3);

        teacherRepository.save(t3);

        Student s4 = new Student();
        s4.setUser(userS4);
        s4.setTeacher(t3);
        studentRepository.save(s4);
        t3.getOwnStudent().add(s4);
        teacherRepository.save(t3);

        Student s5 = new Student();
        s5.setUser(userS5);
        s5.setTeacher(t2);
        studentRepository.save(s5);
        t2.getOwnStudent().add(s5);
        teacherRepository.save(t2);

        Student s6 = new Student();
        s6.setUser(userS6);
        s6.setTeacher(t1);
        studentRepository.save(s6);
        t1.getOwnStudent().add(s6);
        teacherRepository.save(t1);

        Student s7 = new Student();
        s7.setUser(userS7);
        s7.setTeacher(t1);
        studentRepository.save(s7);
        t1.getOwnStudent().add(s7);
        teacherRepository.save(t1);
    }
}