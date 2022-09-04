package com.codehacks.check.registration.controller;

import com.codehacks.check.registration.entities.LoginUser;
import com.codehacks.check.registration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public boolean loginUser(@RequestBody LoginUser user) {
        return authenticateUser(user);
    }

    private boolean authenticateUser(LoginUser user) {
        LoginUser login = loginService.getAUserLogin(user.getEmail());
        return login == null;
    }

    public boolean LogoutUser() {
        return true;
    }
}
