package com.codehacks.blog.repositories;

import com.codehacks.blog.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    /*
    @Query("DELETE b FROM Blog_Post b WHERE b.title = ?1")
    public void deleteBlogPostByTitle(String title);


    @Query("SELECT b FROM Blog_Post b WHERE b.title = ?2")
    public BlogPost getBlogPostByTitle(String title) ;
    */
}
