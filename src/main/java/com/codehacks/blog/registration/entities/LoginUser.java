package com.codehacks.blog.registration.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Login")
@Data
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;

}
