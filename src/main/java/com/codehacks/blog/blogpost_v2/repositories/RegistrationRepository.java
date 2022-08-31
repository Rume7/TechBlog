package com.codehacks.blog.blogpost_v2.repositories;

import com.codehacks.blog.blogpost_v2.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    
}
