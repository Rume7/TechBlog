package com.codehacks.blog.registration.dao;

import com.codehacks.blog.registration.entities.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {

    @Query("SELECT r FROM LoginUser r WHERE r.email=?1")
    LoginUser findLoginUserByEmail(String email);

}
