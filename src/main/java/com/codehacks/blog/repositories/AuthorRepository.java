package com.codehacks.blog.repositories;

import com.codehacks.blog.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    //@Query("SELECT COUNT(b) FROM Blogpost b")
    //public Integer getNumberOfArticlesOfAnAuthor(Long authorId);

}
