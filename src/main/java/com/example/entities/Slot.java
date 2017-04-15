package com.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Slot {


    @Id
    @GeneratedValue
    private Long id;

    private Date startingDate;

    private Date  endingDate;

    @ManyToMany(mappedBy = "slots", fetch= FetchType.EAGER)
    private Collection<User> users;

    @Override
    public String toString() {

        String usersId = new String();

        for( User u : users){
            usersId += String.valueOf(u.getId() + " " );
        }

        return "Slot{" +
                "id=" + id +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", users=" + usersId +
                '}';
    }

    public Slot(Date startingDate, Date endingDate) {
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.users = new ArrayList<>();
    }

    public Slot() {
    }

    public Long getId() {return id;}

    public Date getStartingDate() {return startingDate;}

    public Date getEndingDate() {
        return endingDate;
    }

    public Collection<User> getUsers() {return users;}
}
