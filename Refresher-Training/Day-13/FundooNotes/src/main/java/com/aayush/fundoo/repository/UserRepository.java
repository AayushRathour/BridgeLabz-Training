package com.aayush.fundoo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.fundoo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	Optional<User> findByResetToken(String resetToken);
	
	

}
