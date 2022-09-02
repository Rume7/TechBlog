package com.codehacks.blog.blogpost_v2.repositories;

import com.codehacks.blog.blogpost_v2.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // TODO: Implement query to determine # of blog posts associated with an Author
    @Query("SELECT COUNT(b) FROM Blogpost b WHERE b.author_id=?1")
    public Integer getNumberOfArticlesOfAnAuthor(Author author);

}
