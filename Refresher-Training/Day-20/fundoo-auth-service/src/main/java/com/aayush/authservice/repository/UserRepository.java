package com.aayush.authservice.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.authservice.entity.User;


// Provides database queries for User objects.
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	Optional<User> findByResetToken(String resetToken);
	
	

}
