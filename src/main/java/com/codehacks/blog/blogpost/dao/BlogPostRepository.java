package com.codehacks.blog.blogpost.dao;

import com.codehacks.blog.blogpost.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    @Query("SELECT b FROM Blog_Post b WHERE b.title = ?1")
    public void deleteBlogPostByTitle(String title);
}
