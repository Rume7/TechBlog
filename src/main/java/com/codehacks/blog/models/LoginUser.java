package com.codehacks.blog.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Logins")
@Setter
@Getter
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public LoginUser() {}

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
