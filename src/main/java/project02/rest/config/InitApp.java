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
        userT1.setUsername("broky");
        userT1.setFirstname("broky");
        userT1.setLastname("faze");
        userT1.setPassword("password");
        userT1.setEmail("broky@email.com");
        userT1.setRoles(List.of(Role.ROLE_TEACHER));
        userT1.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160516296-borky.jpg?generation=1698051916574394&alt=media");
        userRepository.save(userT1);


        User userT2 = new User();
        userT2.setUsername("simple");
        userT2.setFirstname("simple");
        userT2.setLastname("navi");
        userT2.setPassword("simpleed");
        userT2.setEmail("simple@navi.com");
        userT2.setRoles(List.of(Role.ROLE_TEACHER));
        userT2.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160516068-Simple.png?generation=1698051916410803&alt=media");
        userRepository.save(userT2);

        User userT3 = new User();
        userT3.setUsername("AJToey");
        userT3.setFirstname("Pathathai");
        userT3.setLastname("Nalumpoon");
        userT3.setEmail("Rosa@Diaz.com");
        userT3.setPassword("Toey321");
        userT3.setRoles(List.of(Role.ROLE_TEACHER));
        userT3.setImage("");
        userRepository.save(userT3);

        User userT4 = new User();
        userT4.setUsername("Charles");
        userT4.setFirstname("Charlie");
        userT4.setLastname("Chaplin");
        userT4.setEmail("Jacop@Peralta.com");
        userT4.setPassword("Chaplin132");
        userT4.setRoles(List.of(Role.ROLE_TEACHER));
        userT4.setImage("");
        userRepository.save(userT4);

        User userS1 = new User();
        userS1.setUsername("niko");
        userS1.setFirstname("Niko");
        userS1.setLastname("Gtwo");
        userS1.setEmail("niko@gtwo.com");
        userS1.setPassword("nikogod");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userS1.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160515877-Niko.png?generation=1698051916174669&alt=media");
        userRepository.save(userS1);

        User userS2 = new User();
        userS2.setUsername("qqgod");
        userS2.setFirstname("Aomsin");
        userS2.setLastname("Nkt");
        userS2.setPassword("qqgod");
        userS2.setEmail("qq@god.com");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userS2.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160515424-qqGOD.png?generation=1698051915984598&alt=media");
        userRepository.save(userS2);

        User userS3 = new User();
        userS3.setUsername("ciggod");
        userS3.setFirstname("Pathipan");
        userS3.setLastname("Posri");
        userS3.setPassword("cigmith");
        userS3.setEmail("cig@god.com");
        userS3.setRoles(List.of(Role.ROLE_STUDENT));
        userS3.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514931-CigaretteS.jpg?generation=1698051915464741&alt=media");
        userRepository.save(userS3);

        User userS4 = new User();
        userS4.setUsername("notail");
        userS4.setFirstname("Daddy");
        userS4.setLastname("Notail");
        userS4.setPassword("ogCEO");
        userS4.setEmail("notail@og.com");
        userS4.setRoles(List.of(Role.ROLE_STUDENT));
        userS4.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514648-Notail.jpg?generation=1698051914985930&alt=media");
        userRepository.save(userS4);

        User userS5 = new User();
        userS5.setUsername("topson");
        userS5.setFirstname("Dadson");
        userS5.setLastname("Trunda");
        userS5.setPassword("dogson");
        userS5.setEmail("topson@trunda.com");
        userS5.setRoles(List.of(Role.ROLE_STUDENT));
        userS5.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514250-Topson.jpeg?generation=1698051914721319&alt=media");
        userRepository.save(userS5);

        User userS6 = new User();
        userS6.setUsername("ana");
        userS6.setFirstname("Anana");
        userS6.setLastname("Pham");
        userS6.setPassword("carrygod");
        userS6.setEmail("ana@humlek.com");
        userS6.setRoles(List.of(Role.ROLE_STUDENT));
        userS6.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160514086-Ana.jpg?generation=1698051914357913&alt=media");
        userRepository.save(userS6);

        User userS7 = new User();
        userS7.setUsername("Forsaken");
        userS7.setFirstname("Konthai");
        userS7.setLastname("Naisingapore");
        userS7.setPassword("RakPgra");
        userS7.setEmail("jason@susanto.com");
        userS7.setRoles(List.of(Role.ROLE_STUDENT));
        userS7.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160513831-Jason.png?generation=1698051914185777&alt=media");
        userRepository.save(userS7);

        User userS8 = new User();
        userS8.setUsername("hrkwannabe");
        userS8.setFirstname("Aek");
        userS8.setLastname("Taupom");
        userS8.setPassword("hrkzaza");
        userS8.setEmail("hrk@taupom.com");
        userS8.setRoles(List.of(Role.ROLE_STUDENT));
        userS8.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160513625-hrk.jpg?generation=1698051913921112&alt=media");
        userRepository.save(userS8);

        User userS9 = new User();
        userS9.setUsername("beatigirl");
        userS9.setFirstname("Konsuay");
        userS9.setLastname("Mehum");
        userS9.setPassword("ladyboy");
        userS9.setEmail("samak@kom.com");
        userS9.setRoles(List.of(Role.ROLE_STUDENT));
        userS9.setImage("");
        userRepository.save(userS9);

        User userS10 = new User();
        userS10.setUsername("Hothothot");
        userS10.setFirstname("Lotto");
        userS10.setLastname("Parker");
        userS10.setPassword("lucky888");
        userS10.setEmail("lotto@gg.com");
        userS10.setRoles(List.of(Role.ROLE_STUDENT));
        userS10.setImage("https://storage.googleapis.com/download/storage/v1/b/imageupload-e5081.appspot.com/o/2023-10-23%20160512500-aek.jpg?generation=1698051913669997&alt=media");
        userRepository.save(userS10);

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
        t5.setUser(userT4);

        Student s8 = new Student();
        s8.setUser(userS8);
        s8.setTeacher(t5);
        studentRepository.save(s8);
        t5.setUser(userT4);
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
