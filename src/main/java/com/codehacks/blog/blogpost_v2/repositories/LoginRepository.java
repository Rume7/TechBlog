package com.codehacks.blog.blogpost_v2.repositories;

import com.codehacks.blog.blogpost_v2.models.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginUser, Long> {

}
