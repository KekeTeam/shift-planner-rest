package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team {


    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
