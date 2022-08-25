package com.codehacks.blog.blogpost.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Blog_Post")
public class BlogPost {

    @Id
    @SequenceGenerator(name="post_sequence",
            sequenceName = "post_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "post_sequence")
    private Long id;

    @Column
    private String title;

    @Column
    private String post;

    @Column
    private Date dateOfPost;

    private Author author;

    public BlogPost() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getPost() { return post; }

    public void setPost(String post) { this.post = post; }

    public Date getDateOfPost() { return dateOfPost; }

    public void setDateOfPost(Date dateOfPost) {this.dateOfPost = dateOfPost; }

    public Author getAuthor() { return author; }

    public void setAuthor(Author author) { this.author = author; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPost blogPost = (BlogPost) o;
        return title.equals(blogPost.title) && post.equals(blogPost.post) && author.equals(blogPost.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, post, author);
    }


}
