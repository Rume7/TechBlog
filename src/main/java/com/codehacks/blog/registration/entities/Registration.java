package com.codehacks.blog.registration.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "RegisteredUser")
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;


}
