package com.codehacks.blog.blogpost_v2.repositories;

import com.codehacks.blog.blogpost_v2.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
