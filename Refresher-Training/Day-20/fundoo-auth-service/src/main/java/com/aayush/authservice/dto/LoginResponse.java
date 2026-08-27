package com.aayush.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// Sends the JWT token back to the client after a successful login.
public class LoginResponse {

	private String token;
	

}
