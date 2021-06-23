package com.noobForce.klasa.service;


import com.noobForce.klasa.model.Announcement;
import com.noobForce.klasa.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
    
    public void deleteAnnouncement() {
        announcementRepository.deleteAll();
    }
    
    public List<Announcement> getAllAnnouncements()
    {
        deleteAnnouncement();
        for (int i = 0; i < 15; i++)
        {
            Random r = new Random();
            String prof = "profname" + Integer.toString((Math.abs(r.nextInt() % 5) + 1));
            String announce = "announcement" + Integer.toString((Math.abs(r.nextInt() % 5) + 1));
            LocalDate date = LocalDate.of(2021, 6, (Math.abs(r.nextInt() % 28) + 1));
//            Announcement an = new Announcement( Long.parseLong(UUID.randomUUID().toString()), prof, announce, date, LocalTime.now());
            Announcement an = new Announcement( prof, announce, date, LocalTime.now());
            addAnnouncement(an);
        }
        return announcementRepository.findAll();
    }
    
    public List<Announcement> getAllAnnouncementsByDate(int date)
    {
        return announcementRepository.findByDate(LocalDate.of(2021, 06, date));
    }
}
