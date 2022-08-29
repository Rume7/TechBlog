package com.codehacks.blog.registration.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "RegisteredUser")
@Data
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String email;

    @NonNull
    @Column(length = 65, nullable = false)
    private String password;
    private String confirmPassword;

    @NonNull
    @Column(length = 20)
    private String firstName;

    @NonNull
    @Column(length = 20)
    private String lastName;


}
