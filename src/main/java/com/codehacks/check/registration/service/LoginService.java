package com.codehacks.check.registration.service;

import com.codehacks.check.registration.dao.LoginUserRepository;
import com.codehacks.check.registration.entities.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    public List<LoginUser> getAllLoginUsers() {
        return loginUserRepository.findAll();
    }

    public LoginUser getAUserLogin(String email) {
        return loginUserRepository.findLoginUserByEmail(email);
    }

    /* column in the form of username | salt | password. */
    public String getUserPassword(String email) {
        return getAUserLogin(email).getPassword();
    }
}
