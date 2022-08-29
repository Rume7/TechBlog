package com.codehacks.blog.registration.controller;

import com.codehacks.blog.registration.entities.Registration;
import com.codehacks.blog.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    private Registration registerUser(Registration newUser) {
        // Check if the user is in the database
        // if true, send message back to the registration page notifying of existing login or email already taken
        // else register the user.
        //
        return null;
    }

    public Registration updateUser(Registration user) {
        // Check if the user is in the database.
        // If Yes, update the database
        // else throw exception

        return null;
    }

    public boolean deleteUser(String email) {
        // Check if user exists
        // If true, delete user and return true
        // else return false
        //Registration user = registrationService.findUserByEmail(email);
        //registrationService.delete(user);
        return true;
    }
}
