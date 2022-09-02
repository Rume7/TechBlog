package com.codehacks.blog.blogpost_v2.models;

import javax.persistence.*;

@Entity
@Table(name = "Logins")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
}
