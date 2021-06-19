package com.noobForce.klasa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Discussion implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private LocalDate date;
    private LocalTime time;
    private String input;

    public Discussion() {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Discussion(String input) {
        this.input = input;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.now();
    }

    public void setTime(LocalTime time) {
        this.time = LocalTime.now();
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", input='" + input + '\'' +
                '}';
    }
}
