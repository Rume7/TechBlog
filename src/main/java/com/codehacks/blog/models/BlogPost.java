package com.codehacks.blog.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Posts")
@Data
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Input the Title")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    private Instant dateCreated;

    @OneToOne(fetch = FetchType.LAZY)
    private Author authors;

    @OneToMany()
    private List<Comment> comments;

    public BlogPost(){}

    public BlogPost(String title) {
        this.title = title;
        this.content = "";
        this.dateCreated = Instant.now();
        this.comments = new ArrayList<>();
    }

    public BlogPost(final String title, final String content, final Author author) {
        this.title = title;
        this.content = content;
        this.dateCreated = Instant.now();
        this.comments = new ArrayList<>();
        this.authors = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPost blogPost = (BlogPost) o;
        return title.equals(blogPost.title) && dateCreated.equals(blogPost.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, dateCreated);
    }
}
