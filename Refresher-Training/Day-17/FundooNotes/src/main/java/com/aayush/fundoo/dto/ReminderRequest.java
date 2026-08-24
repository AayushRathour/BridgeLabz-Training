package com.aayush.fundoo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// Holds the reminder time to set on a note. Send null to clear an existing reminder.
public class ReminderRequest {

	private LocalDateTime reminderAt;
}
