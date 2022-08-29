package com.codehacks.blog.registration.controller.utility;

public class PasswordEncoder {

    public BCryptPassword encode(String password) {
        new BCryptPasswordEncoder(password);
    }
}
