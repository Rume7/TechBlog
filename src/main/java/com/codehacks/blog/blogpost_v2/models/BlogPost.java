package com.codehacks.blog.blogpost_v2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String short_description;
    private String content;
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name = "Author_id")
    private List<Author> authors;

}
