package com.aayush.reminderservice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

/**
 * Response body returned by all reminder endpoints.
 * Carries the note id, reminder time, and whether the reminder has already fired.
 */
@Getter
@Builder
public class ReminderResponse {

    /** ID of the note on which the reminder is set */
    private Long noteId;

    /** Note title — so the caller knows which note was updated */
    private String title;

    /**
     * The scheduled reminder time.
     * Null means no reminder is currently set.
     */
    private LocalDateTime reminderAt;

    /**
     * True if the scheduler has already processed this reminder.
     * Once true, the reminder will not fire again unless re-set.
     */
    private boolean reminderSent;

    /** Timestamp of the last update to the note */
    private LocalDateTime updatedAt;
}
