package com.codehacks.blog.blogpost_v2.services;

import com.codehacks.blog.blogpost_v2.models.Author;
import com.codehacks.blog.blogpost_v2.repositories.AuthorRepository;
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
            return authorRepository.getNumberOfArticlesOfAnAuthor(author);
        }
        throw new IllegalArgumentException("");
    }
}
