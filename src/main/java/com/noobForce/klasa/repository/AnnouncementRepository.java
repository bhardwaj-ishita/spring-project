package com.noobForce.klasa.repository;

import com.noobForce.klasa.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long>
{
}
