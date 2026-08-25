package com.aayush.fundoo.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

// Holds the safe note data returned to API clients.
@Getter
@Setter
public class NoteResponse {
	private Long id;
	private String title;
	private String content;
	private boolean pinned;
	private boolean archived;
	private boolean trashed;
	private LocalDateTime reminderAt;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Set<String> tags;
}
