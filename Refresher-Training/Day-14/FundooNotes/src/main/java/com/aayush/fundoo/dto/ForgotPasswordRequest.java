package com.aayush.fundoo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Holds and validates the email sent to start password recovery.
public class ForgotPasswordRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;
}
