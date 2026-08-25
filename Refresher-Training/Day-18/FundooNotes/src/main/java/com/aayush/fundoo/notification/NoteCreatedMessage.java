package com.aayush.fundoo.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Defines the JSON payload sent through the note-created RabbitMQ queue.
public class NoteCreatedMessage {
	private Long noteId;
	private String titel;
	private String userEmail;
	

}
