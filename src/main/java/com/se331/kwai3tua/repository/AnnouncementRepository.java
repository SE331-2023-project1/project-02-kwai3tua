package com.se331.kwai3tua.repository;

import com.se331.kwai3tua.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long>{
    List<Announcement> findAll();
}