package com.codehacks.check.registration.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Login")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String password;

    public LoginUser() {}

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {return id;}

    public String getEmail() {return email;}

    public String getPassword() {return password;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginUser loginUser = (LoginUser) o;
        return email.equals(loginUser.email) && password.equals(loginUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "LoginUser{" + "id = " + id + ", email = '" + email + '}';
    }
}
