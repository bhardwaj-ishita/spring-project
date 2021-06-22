package com.noobForce.klasa.service;


import com.noobForce.klasa.model.Announcement;
import com.noobForce.klasa.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnnouncementService
{
    private final AnnouncementRepository announcementRepository;
    
    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository)
    {
        this.announcementRepository = announcementRepository;
    }
    
    public Announcement addAnnouncement(Announcement announcement)
    {
        return announcementRepository.save(announcement);
    }
    
    public List<Announcement> getAllAnnouncements()
    {
        return announcementRepository.findAll();
    }
    
    public List<Announcement> getAllAnnouncementsByDate(int date)
    {
        return announcementRepository.findByDate(LocalDate.of(2021, 06, date));
    }
}
