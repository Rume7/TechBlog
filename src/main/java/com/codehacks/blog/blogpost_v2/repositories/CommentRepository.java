package com.codehacks.blog.blogpost_v2.repositories;

import com.codehacks.blog.blogpost_v2.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
