package com.codehacks.blog.services;

import com.codehacks.blog.models.Registration;
import com.codehacks.blog.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void registerNewUser(Registration registration) {
        registrationRepository.save(registration);
    }

    public Registration getUser(String email) {
        return registrationRepository.findByEmail(email);
    }

    @Transactional
    public void updateExistingUserProfile(Registration registration) {
        if (checkIfUserExists(registration.getEmail())) {
            Registration updateRegistration = new Registration();
            //updateRegistration.setId(registration.getId());
            updateRegistration.setEmail(registration.getEmail());
            updateRegistration.setFirstName(registration.getFirstName());
            updateRegistration.setLastName(registration.getLastName());
            updateRegistration.setCreatedDate(registration.getCreatedDate());
            registrationRepository.save(updateRegistration);
        }
        throw new IllegalArgumentException("User does not exist");
    }

    public boolean checkIfUserExists(String email) {
        Registration registrant = registrationRepository.findByEmail(email);
        return registrant != null;
    }

    public void deleteExistingUser(String email) {
        Registration registeredUser = getUser(email);
        if(registeredUser != null) {
            registrationRepository.delete(registeredUser);
        }
    }
}
