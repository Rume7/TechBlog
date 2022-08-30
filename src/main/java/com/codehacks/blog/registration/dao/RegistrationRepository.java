package com.codehacks.blog.registration.dao;

import com.codehacks.blog.registration.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query("SELECT r FROM Registration r WHERE r.email=?1")
    Registration findUserByEmail(String email);
}
