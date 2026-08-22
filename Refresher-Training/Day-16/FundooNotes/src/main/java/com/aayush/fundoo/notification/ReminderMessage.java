package com.aayush.fundoo.notification;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Plain, serializable payload sent onto the JMS queue for one due reminder.
// Serializable is required because Spring's default JMS message converter
// turns Java objects into a JMS ObjectMessage.
public class ReminderMessage implements Serializable {

	private Long noteId;
	private String noteTitle;
	private String userEmail;
	private LocalDateTime reminderAt;
}
