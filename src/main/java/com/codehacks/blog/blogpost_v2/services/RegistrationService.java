package com.codehacks.blog.blogpost_v2.services;

import com.codehacks.blog.blogpost_v2.models.Registration;
import com.codehacks.blog.blogpost_v2.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public void registerNewUser(Registration registration) {

    }

    public void updateExistingUserProfile(Registration registration) {

    }

    public void deleteExistingUser(String email) {

    }
}
