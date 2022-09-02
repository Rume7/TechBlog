package com.codehacks.blog.repositories;

import com.codehacks.blog.models.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginUser, Long> {

}
