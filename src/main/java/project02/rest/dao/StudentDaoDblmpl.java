package project02.rest.dao;

import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Student;
import project02.rest.repository.StudentRepository;
import project02.rest.security.user.User;
import project02.rest.security.user.UserRepository;
import project02.rest.util.CloudStorageHelper;

import java.io.IOException;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDblmpl implements StudentDao {

    final StudentRepository studentRepository;
    final UserRepository userRepository;
    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Student> getStudents(String filter, Pageable page) {
        return studentRepository.findByUser_FirstnameOrUser_LastnameOrUser_Username(filter,filter,filter, page);
    }

    @Override
    public Page<Student> findByUser_Firstname(String firstname, Pageable page) {
        return null;
    }


    @Override
    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public User updateStudent(Long id, User updatedUser, MultipartFile imageFile) {
        return studentRepository.findById(id)
                .map(student -> {
                    User user = student.getUser();
                    if (updatedUser.getFirstname() != null) {
                        user.setFirstname(updatedUser.getFirstname());
                    }
                    if (updatedUser.getLastname() != null) {
                        user.setLastname(updatedUser.getLastname());
                    }
                    if (updatedUser.getUsername() != null) {
                        user.setUsername(updatedUser.getUsername());
                    }
                    if (updatedUser.getEmail() != null) {
                        user.setEmail(updatedUser.getEmail());
                    }
                    if (updatedUser.getPassword() != null) {
                        user.setPassword(updatedUser.getPassword());
                    }
                    if (imageFile != null && !imageFile.isEmpty()) {
                        String imageUrl = null;
                        try {
                            imageUrl = cloudStorageHelper.getImageUrl(imageFile, "imageupload-e5081.appspot.com");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (ServletException e) {
                            throw new RuntimeException(e);
                        }
                        user.setImage(imageUrl);
                    }
                    return userRepository.save(user);
                })
                .orElse(null);
    }
}
