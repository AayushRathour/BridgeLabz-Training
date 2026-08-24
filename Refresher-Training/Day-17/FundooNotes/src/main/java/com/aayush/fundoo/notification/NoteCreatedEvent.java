package com.aayush.fundoo.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// Carries saved-note details from the database transaction to the RabbitMQ publisher.
public class NoteCreatedEvent {

	private Long noteId;
	private String titel;
	private String useremail;
	
}
