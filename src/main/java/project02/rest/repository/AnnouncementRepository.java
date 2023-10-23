package project02.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project02.rest.entity.Announcement;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
    List<Announcement> findAll();
}
