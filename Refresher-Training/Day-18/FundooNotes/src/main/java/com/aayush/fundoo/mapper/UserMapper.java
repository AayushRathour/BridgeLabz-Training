package com.aayush.fundoo.mapper;

import org.springframework.stereotype.Component;

import com.aayush.fundoo.dto.RegisterRequest;
import com.aayush.fundoo.dto.UserResponse;
import com.aayush.fundoo.entity.User;

@Component
public class UserMapper {

	// Converts registration input into a new User entity.
	public User toEntity(RegisterRequest request) {
		User user = new User();
		user.setFirstName(request.getFirstname().trim());
		user.setLastName(request.getLastname().trim());
		user.setEmail(request.getEmail().trim());
		return user;
	}

	// Converts a User entity into safe profile data without credentials.
	public UserResponse toResponse(User user) {
		UserResponse response = new UserResponse();
		response.setId(user.getId());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		return response;
	}
}
