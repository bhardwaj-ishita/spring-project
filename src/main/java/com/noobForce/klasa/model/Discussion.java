package com.noobForce.klasa.model;

import org.hibernate.type.LocalDateType;
import org.hibernate.type.LocalTimeType;

import javax.persistence.*;

@Entity
@Table (name = "discussions", schema = "classroom")
public class Discussion {

    private @Id @GeneratedValue long id;
    private final LocalDateType date = new LocalDateType();
    private final LocalTimeType time = new LocalTimeType();
    private String input;
    private Student student;

    public Discussion() {
    }

    public Discussion(String input) {
        this.input = input;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateType getDate() {
        return date;
    }

    public LocalTimeType getTime() {
        return time;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @OneToOne
    @JoinColumn(name = "id", nullable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Discussion{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", input='" + input + '\'' +
                ", student=" + student +
                '}';
    }
}
