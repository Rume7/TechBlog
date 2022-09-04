package com.codehacks.check.registration.controller;

import com.codehacks.check.registration.entities.Registration;
import com.codehacks.check.registration.service.RegistrationService;
import com.codehacks.check.registration.controller.utility.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Controller
@Transactional
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private MyPasswordEncoder passwordEncoder;

    public Registration registerUser(final Registration newUser) throws IllegalArgumentException {
        if (!checkIfUserExist(newUser)) {
            String hashedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(hashedPassword);
            registrationService.registerUser(newUser);
        }
        throw new IllegalArgumentException("Already existing user");
    }

    public Registration updateUser(Registration user) {
        if (checkIfUserExist(user)) {
            Registration newUser = new Registration();
            newUser.setEmail(user.getEmail());
            newUser.setUsername(user.getUsername());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setId(user.getId());
            registrationService.updateUserProfile(newUser);
        }
        return null;
    }

    public boolean deleteAccount(String email) {
        Registration regUser = registrationService.getARegisteredUser(email);
        if (regUser != null) {
            registrationService.delete(regUser);
            return true;
        }
        return false;
    }

    private boolean checkIfUserExist(@NonNull Registration user) {
        return registrationService.getAllRegisteredUsers().parallelStream()
                .filter(each -> user.getEmail().equals(each.getEmail()))
                .filter(aUser -> user.getPassword().equals(aUser.getPassword()))
                .collect(Collectors.toList()).size() == 1;
    }
}
