package com.codehacks.blog.controller;

import com.codehacks.blog.models.Registration;
import com.codehacks.blog.services.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.Instant;

@Controller
public class RegistrationController {
    private final Logger logger = LoggerFactory.getLogger(Registration.class);

    @Autowired
    private RegistrationService registrationService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping(value = "/register")
    public String processRegister(@Valid Registration registration, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registerUser";
        }
        logger.info("Request to REGISTER user " + registration.getUsername());
        String hashedPassword = passwordEncoder().encode(registration.getPassword());
        registration.setCreatedDate(Instant.now());
        registration.setPassword(hashedPassword);
        registrationService.registerNewUser(registration);
        return "redirect:/confirm_registration";
    }

    @PostMapping("/update_profile/{id}")
    public String updateProfile(@PathVariable("id") Long id, final Registration registration, BindingResult result,
                                Model model) {
        if(result.hasErrors()) {
            registration.setId(id);
            return "update-profile";
        }
        logger.info("Request to UPDATE User: " + registration.getUsername());
        Registration updatedProfile = new Registration();
        updatedProfile.setId(id);
        updatedProfile.setUsername(registration.getUsername());
        updatedProfile.setEmail(registration.getEmail());
        updatedProfile.setFirstName(registration.getFirstName());
        updatedProfile.setLastName(registration.getLastName());
        updatedProfile.setPassword(passwordEncoder().encode(registration.getPassword()));
        registrationService.updateExistingUserProfile(updatedProfile);
        return "redirect:/index";
    }

    @PostMapping("/unsubscribe/{email}")
    public String unsubscribe(@PathVariable("email") String email) {
        logger.info("Request to DELETE user: " + email);
        registrationService.deleteExistingUser(email);
        return "redirect:/index";
    }
}
