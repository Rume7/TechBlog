package com.codehacks.blog.registration.service;

import com.codehacks.blog.registration.controller.dao.RegistrationRepository;
import com.codehacks.blog.registration.entities.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration registerUser(Registration newUser) {
        Registration registeredUser = registrationRepository.findUserByEmail(newUser.getEmail());
        if (registeredUser == null) {
            registrationRepository.save(newUser);
            return newUser;
        }
        throw new IllegalArgumentException("The user already exists");
    }


    public boolean delete(Registration user) {
        Registration registeredUser = registrationRepository.findUserByEmail(user.getEmail());
        if (registeredUser != null) {
            registrationRepository.delete(user);
            return true;
        }
        return false;
    }
}
