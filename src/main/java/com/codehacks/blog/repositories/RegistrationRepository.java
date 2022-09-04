package com.codehacks.blog.repositories;

import com.codehacks.blog.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    @Query("SELECT s FROM Registration s WHERE s.email = ?1")
    public Registration findByEmail(String email);
}
