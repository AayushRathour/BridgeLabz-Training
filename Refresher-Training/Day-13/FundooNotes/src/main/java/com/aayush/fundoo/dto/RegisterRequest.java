package com.aayush.fundoo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterRequest {
	
	@NotBlank(message= "first name cannot be Empty")
	private String firstname;
	
	@NotBlank(message= "last name cannot be Empty")
	private String lastname;
	
	@NotBlank(message = "Email is needed, cannot be empty")
	@Email(message= "Invalid email")
	private String email;
	
	@NotBlank(message= "Password is needed")
	@Size(min =8, message ="Password must contain at least 8 characters")
	private String password;
	

}
