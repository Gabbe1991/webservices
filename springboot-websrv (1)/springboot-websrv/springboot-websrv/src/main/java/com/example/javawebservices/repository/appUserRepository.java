package com.example.javawebservices.repository;

import com.example.javawebservices.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface appUserRepository extends JpaRepository<AppUser, Long> {

        Optional<AppUser> findAppUserByUsername(String username);
}
