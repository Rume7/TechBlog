package com.codehacks.blog.repositories;

import com.codehacks.blog.models.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
