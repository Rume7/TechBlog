package com.codehacks.blog.blogpost_v2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "RegisteredUser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 65, nullable = false)
    private String password;
    private String email;
    private String username;
    private String firstName;
    private String lastName;

}
