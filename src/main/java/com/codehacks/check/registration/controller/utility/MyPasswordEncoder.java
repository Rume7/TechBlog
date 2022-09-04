package com.codehacks.check.registration.controller.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@Configuration
public class MyPasswordEncoder {

    @Bean
    public String encode(String password) {
        int strength = 16;
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());

        String encodedPassword = bCryptPasswordEncoder.encode(password);
        return encodedPassword;
    }
}
