package com.aayush.reminderservice.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Request body for setting a reminder on a note.
 *
 * Example JSON:
 * {
 *   "reminderAt": "2026-09-01T08:30:00"
 * }
 */
@Getter
@Setter
public class ReminderRequest {

    /**
     * The exact date-time at which the reminder should fire.
     * Must be a future timestamp.
     */
    @NotNull(message = "reminderAt is required")
    @Future(message = "reminderAt must be a future date-time")
    private LocalDateTime reminderAt;
}
