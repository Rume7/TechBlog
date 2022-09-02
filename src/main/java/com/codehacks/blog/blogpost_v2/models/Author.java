package com.codehacks.blog.blogpost_v2.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

}
