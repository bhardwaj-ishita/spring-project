package com.noobForce.klasa.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Announcement implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private String nameOfProfessor;
    private String announcement;
    private LocalDate date;
    private LocalTime time;



    public Announcement()
    {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Announcement(String announcement) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.announcement = announcement;
    }
    
    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getNameOfProfessor()
    {
        return nameOfProfessor;
    }
    
    public void setNameOfProfessor(String nameOfProfessor)
    {
        this.nameOfProfessor = nameOfProfessor;
    }
    
    public String getAnnouncement()
    {
        return announcement;
    }
    
    public void setAnnouncement(String announcement)
    {
        this.announcement = announcement;
    }
    
    public LocalDate getDate()
    {
        return this.date = LocalDate.now();
    }

    public LocalTime getTime()
    {
        return this.time = LocalTime.now();
    }
    
    @Override
    public String toString()
    {
        return "Announcement{" +
                "id=" + id +
                ", nameOfProfessor='" + nameOfProfessor + '\'' +
                ", announcement='" + announcement + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
