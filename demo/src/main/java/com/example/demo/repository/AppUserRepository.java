package com.example.demo.repository;

import com.example.demo.domain.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//This repository provides a read-only method to find an AppUser by their email address.

//The AppUserRepository interface extends JpaRepository to provide data access
// methods for the AppUser entity. It includes a custom method findByEmail
// (String email) that retrieves an AppUser from the database by email,
// returning an Optional<AppUser>, and inherits standard CRUD operations
// like save, findById, and deleteById from JpaRepository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}