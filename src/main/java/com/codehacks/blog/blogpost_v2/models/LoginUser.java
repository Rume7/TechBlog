package com.codehacks.blog.blogpost_v2.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginUser {

    @Id
    private String email;
    private String password;
}
