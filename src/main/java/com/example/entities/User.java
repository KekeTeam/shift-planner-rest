package com.example.entities;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long id;

    private String lastName;

    private String firstName;

    private String phone; //could also be a Line id

    private String email;

    private String login;

    private String password;

    @ManyToMany(fetch= FetchType.EAGER) //EAGER is usefull because we access the collection after hibernate session is close
    private Collection<Property> properties;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", properties=" + properties +
                '}';
    }

    public User() {

    }

    public User(String lastName, String firstName, String phone, String email, String login, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.login = login;
        this.password = password;
        this.properties = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Collection<Property> getProperties() {
        return properties;
    }
}
