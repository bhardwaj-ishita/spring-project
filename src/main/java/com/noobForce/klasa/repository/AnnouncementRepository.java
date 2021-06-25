package com.noobForce.klasa.repository;

import com.noobForce.klasa.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface AnnouncementRepository extends JpaRepository<Announcement, Long>
{
    List<Announcement> findByDate(LocalDate date);
}
