package com.noobForce.klasa.controller;


import com.noobForce.klasa.model.Announcement;
import com.noobForce.klasa.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
public class AnnouncementController
{
    private final AnnouncementService announcementService;
    
    @Autowired
    public AnnouncementController(AnnouncementService announcementService)
    {
        this.announcementService = announcementService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<Announcement> addAnnouncement(@RequestBody Announcement announcement)
    {
        return new ResponseEntity<>(announcementService.addAnnouncement(announcement), HttpStatus.CREATED);
        
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Announcement>> getAllAnnouncements()
    {
        return new ResponseEntity<>(announcementService.getAllAnnouncements(), HttpStatus.OK);
    }
}
