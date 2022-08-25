package com.codehacks.blog.blogpost.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    private Long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name="No_of_Articles")
    private int numberOfArticles;

    public Author(String firstName, String lastName, String email, int numberOfArticles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.numberOfArticles = numberOfArticles;
    }

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getName() { return getFirstName().concat(" ").concat(getLastName()); }

    public int getNumberOfArticles() { return this.numberOfArticles; }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " # of articles: " + this.getNumberOfArticles();
    }
}
