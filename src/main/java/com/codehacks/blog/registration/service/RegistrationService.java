package com.codehacks.blog.registration.service;

import com.codehacks.blog.registration.controller.utility.MyPasswordEncoder;
import com.codehacks.blog.registration.dao.RegistrationRepository;
import com.codehacks.blog.registration.entities.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Transactional
    public Registration registerUser(Registration newUser) {
        Registration registeredUser = registrationRepository.findUserByEmail(newUser.getEmail());
        if (registeredUser == null) {
            registrationRepository.save(newUser);
            return newUser;
        }
        throw new IllegalArgumentException("The user already exists");
    }

    public List<Registration> getAllRegisteredUsers() {
        return registrationRepository.findAll();
    }

    public Registration getARegisteredUser(String email) {
        return registrationRepository.findUserByEmail(email);
    }

    public Registration updateUserProfile(Registration user) {
        Registration registrant = registrationRepository.findUserByEmail(user.getEmail());
        if (registrant != null) {
            registrant.setFirstName(user.getFirstName());
            registrant.setLastName(user.getLastName());
            registrant.setPassword(user.getPassword());
            registrant.setUsername(user.getUsername());
            registrationRepository.save(registrant);
        }
        throw new IllegalArgumentException("User " + user.getEmail() + " doesn't exist.");
    }

    @Transactional
    public boolean changePassword(String email, String newPassword) {
        Registration registeredUser = registrationRepository.findUserByEmail(email);
        if(registeredUser != null) {
            String encodedPassword = new MyPasswordEncoder().encode(newPassword);
            registeredUser.setPassword(encodedPassword);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean delete(Registration user) {
        Registration registeredUser = registrationRepository.findUserByEmail(user.getEmail());
        if (registeredUser != null) {
            registrationRepository.delete(user);
            return true;
        }
        return false;
    }
}
