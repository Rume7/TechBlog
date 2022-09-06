package com.codehacks.blog.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Posts")
@Getter
@Setter
@NoArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Input the Title")
    @NotNull
    private String title;

    @NotBlank(message = "Content is required")
    @NotNull
    private String content;

    @NotNull
    private Instant dateCreated;

    @OneToOne
    @NotNull
    private Author author;

    @OneToMany()
    private List<Comment> comments;

    public BlogPost(final String title, final String content, final Author author) {
        this.title = title;
        this.content = content;
        this.dateCreated = Instant.now();
        this.author = author;
        this.comments = new ArrayList<>();
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
