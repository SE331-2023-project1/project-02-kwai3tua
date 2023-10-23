package com.se331.kwai3tua.service;

import com.se331.kwai3tua.entity.Announcement;
import com.se331.kwai3tua.entity.Teacher;
import com.se331.kwai3tua.repository.AnnouncementRepository;
import com.se331.kwai3tua.repository.TeacherRepository;
import com.se331.kwai3tua.util.CloudStorageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Announcement createAnnouncement(Long teacherId, Announcement announcement) {
        Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);
        announcement.setTeacher(teacherOpt.get());
        return announcementRepository.save(announcement);
    }
}