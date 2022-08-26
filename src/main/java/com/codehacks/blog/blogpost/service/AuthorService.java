package com.codehacks.blog.blogpost.service;

import com.codehacks.blog.blogpost.dao.AuthorRepository;
import com.codehacks.blog.blogpost.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    
    public Author getAnAuthorByEmail(String email) {
        return authorRepository.findAll().stream()
                .filter(author -> author.getEmail().equals(email))
                .findFirst().orElse(null);
    }

    public Integer getAuthorsNumberOfPublications(Author author) {
        if (getAllAuthors().contains(author)) {
            return authorRepository.findAll().stream()
                    .filter(writer -> writer.getEmail().equals(author.getEmail()))
                    .findFirst().get().getNumberOfArticles();
        }
        throw new IllegalArgumentException("");
    }
}
