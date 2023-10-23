package project02.rest.service;

import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Announcement;

public interface AnnouncementService {
    Announcement createAnnouncement(Long teacherId, Announcement announcement, MultipartFile files);

}
