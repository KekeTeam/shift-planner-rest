package com.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Property {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "properties", fetch= FetchType.EAGER)
    private Collection<User> users;


    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                //", users=" + users +
                '}';
    }

    public Property() {
    }

    public Property(String name, String description) {
        this.name = name;
        this.description = description;
        this.users = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<User> getUsers() {
        return users;
    }
}
