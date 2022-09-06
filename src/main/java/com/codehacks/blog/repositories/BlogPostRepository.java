package com.codehacks.blog.repositories;

import com.codehacks.blog.models.Author;
import com.codehacks.blog.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    /*
    @Query("DELETE b FROM Blog_Post b WHERE b.title = ?1")
    public void deleteBlogPostByTitle(String title);


    @Query("SELECT b FROM Blog_Post b WHERE b.title = ?2")
    public BlogPost getBlogPostByTitle(String title) ;
    */

    // TODO: Think of search a Blog repository using the title, date and author parameters.

    @Query()
    public List<BlogPost> getBlogPostByTitle(String title);

    @Query()
    public List<BlogPost> getBlogPostPublishedOn(LocalDate datePublished);

    @Query()
    public List<BlogPost> getBlogPostByAuthor(Author author);
}
