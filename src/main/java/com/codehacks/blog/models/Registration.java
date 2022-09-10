package com.codehacks.blog.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "RegisteredUser")
@Getter
@Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String username;

    @Column(length = 65, nullable = false)
    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private String firstName;

    @NotBlank
    @NotNull
    private String lastName;

    private Instant createdDate;

    public Registration(){
        this.createdDate = Instant.now();
    }

    public Registration(String email, String username, String password, String firstName, String lastName) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return email.equals(that.email) && username.equals(that.username) && firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, username);
    }

    @Override
    public String toString() {
        return "Registration{" + "id=" + id + ", email='" + email + '\'' +
                ", username='" + username + '\'' + ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' + ", createdDate=" + createdDate + '}';
    }
}
