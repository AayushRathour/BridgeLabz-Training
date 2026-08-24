package com.aayush.fundoo.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Holds and validates the title and content used to create a note.
public class NoteRequest {

	@NotBlank(message = "Title cannot be empty")
	private String title;
	
	@NotBlank(message = "Content cannot be blank")
	private String content;
	
	private Set<String> tags;
}

