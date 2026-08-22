package com.aayush.fundoo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Holds and validates the email and password sent for login.
public class LoginRequest {

	@NotBlank(message = "Email cannot be Empty")
	@Email(message= "Email is not valid")
	private String email;
	
	@NotBlank(message = " Password is needed")
	private String password;
	
}
