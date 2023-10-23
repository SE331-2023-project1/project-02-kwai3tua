package project02.rest.service;

import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Announcement;
import project02.rest.entity.Teacher;
import project02.rest.repository.AnnouncementRepository;
import project02.rest.repository.TeacherRepository;
import project02.rest.util.CloudStorageHelper;

import java.io.IOException;
import java.util.Optional;

@Service
public class AnnouncementServicelmpl implements AnnouncementService{

    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Announcement createAnnouncement(Long teacherId, Announcement announcement, MultipartFile files) {
        Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);


        announcement.setTeacher(teacherOpt.get());
        if (files != null && !files.isEmpty()) {
            String filesUrl = null;
            try {
                filesUrl = cloudStorageHelper.getImageUrl(files, "imageupload-e5081.appspot.com");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
            announcement.setFile(filesUrl);
        }

        return announcementRepository.save(announcement);
    }
}
