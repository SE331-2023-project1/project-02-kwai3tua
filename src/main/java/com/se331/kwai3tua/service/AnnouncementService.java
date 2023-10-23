package com.se331.kwai3tua.service;

import com.se331.kwai3tua.entity.Announcement;
import org.springframework.stereotype.Service;

@Service
public interface AnnouncementService {

    Announcement createAnnouncement(Long teacherId, Announcement announcement);
}