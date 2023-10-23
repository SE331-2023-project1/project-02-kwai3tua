package project02.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project02.rest.entity.Announcement;
import project02.rest.entity.AnnouncementDTO;
import project02.rest.repository.AnnouncementRepository;
import project02.rest.service.AnnouncementService;
import project02.rest.util.CloudStorageHelper;
import project02.rest.util.LabMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/announcements")
@RequiredArgsConstructor
public class AnnouncementController {
    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private AnnouncementRepository announcementRepository;


    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@RequestParam("teacherId") Long teacherId, @ModelAttribute Announcement announcement, @RequestPart("files") MultipartFile files) {
        AnnouncementDTO announcementDTO = LabMapper.INSTANCE.getAnnouncementDTO(announcementService.createAnnouncement(teacherId, announcement, files));
        return ResponseEntity.ok(announcementDTO);

    }
    @GetMapping("/")
    public ResponseEntity<List<AnnouncementDTO>> getAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        List<AnnouncementDTO> announcementDTOs = announcements.stream()
                .map(announcement -> LabMapper.INSTANCE.getAnnouncementDTO(announcement))
                .collect(Collectors.toList());
        return ResponseEntity.ok(announcementDTOs);
    }

    @GetMapping("/{announcementId}")
    public ResponseEntity<AnnouncementDTO> getSingleAnnouncement(@PathVariable Long announcementId) {
        Optional<Announcement> announcement = announcementRepository.findById(announcementId);
        if (announcement.isPresent()) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(announcement.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
