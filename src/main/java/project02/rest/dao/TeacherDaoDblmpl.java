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
import project02.rest.entity.Teacher;
import project02.rest.repository.TeacherRepository;
import project02.rest.security.user.User;
import project02.rest.security.user.UserRepository;
import project02.rest.util.CloudStorageHelper;

import java.io.IOException;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class TeacherDaoDblmpl implements TeacherDao {

    final TeacherRepository teacherRepository;
    final UserRepository userRepository;
    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    @Override
    public Integer getTeacherSize() {
        return Math.toIntExact(teacherRepository.count());
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherRepository.findAll();
    }

    @Override
    public Page<Teacher> getTeachers(String filter, Pageable page) {
        return teacherRepository.findByUser_FirstnameOrUser_LastnameOrUser_Username(filter,filter,filter, page);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public User updateTeacher(Long id, User updatedUser, MultipartFile imageFile) {
        return teacherRepository.findById(id)
                .map(teacher -> {
                    User user = teacher.getUser();
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
                    if (updatedUser.getImage() != null) {
                        user.setImage(updatedUser.getImage());
                    }
                    if (imageFile != null && !imageFile.isEmpty()) {
                        String imageUrl = null;
                        try {
                            imageUrl = cloudStorageHelper.getImageUrl(imageFile, "se-lab-331-imageuplaod.appspot.com");
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

