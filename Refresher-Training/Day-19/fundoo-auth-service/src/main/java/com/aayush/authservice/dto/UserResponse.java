package com.aayush.authservice.dto;

import lombok.Getter;
import lombok.Setter;

// Holds the safe user profile data returned to API clients.
@Getter
@Setter
public class UserResponse {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
}
