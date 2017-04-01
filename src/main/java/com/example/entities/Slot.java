package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Slot {


    @Id
    @GeneratedValue
    private Long id;

    private Date startingDate;

    private Date  endingDate;


    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                '}';
    }

    public Slot(Date startingDate, Date endingDate) {
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public Slot() {
    }

    public Long getId() {
        return id;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }
}
