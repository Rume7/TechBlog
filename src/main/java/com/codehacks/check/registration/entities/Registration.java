package com.codehacks.blog.check.registration.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "RegisteredUser")
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String email;

    @NonNull
    @Column(length = 65, nullable = false)
    private String password;

    @NonNull
    @Column(length = 14)
    private String username;

    @NonNull
    @Column(length = 20)
    private String firstName;

    @NonNull
    @Column(length = 20)
    private String lastName;

    public Registration() {}

    public Registration(@NonNull String email, @NonNull String password, @NonNull String username,
                        @NonNull String firstName, @NonNull String lastName) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "email='" + email + ", username='" + username + '\'' +
                ", firstName='" + firstName + ", lastName='" + lastName + '}';
    }

}
