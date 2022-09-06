package com.codehacks.blog.services;

import com.codehacks.blog.models.Author;
import com.codehacks.blog.repositories.AuthorRepository;
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

    public Author getAuthorByEmail(String email) {
        return authorRepository.findAll().parallelStream()
                .filter(author -> author.getEmail().equals(email))
                .findFirst().orElse(null);
    }

    /*
    public Integer getAuthorsNumberOfPublications(Author author) {
        Author foundAuthor = getAuthorByEmail(author.getEmail());
        if (foundAuthor != null) {
            String firstName = foundAuthor.getFirstName();
            String lastName = foundAuthor.getLastName();
            if (firstName.equals(author.getFirstName()) && lastName.equals(author.getLastName())) {
                return authorRepository.getNumberOfArticlesOfAnAuthor(foundAuthor.getId());
            }
        }
        throw new IllegalArgumentException("Author not found");
    }*/
}
