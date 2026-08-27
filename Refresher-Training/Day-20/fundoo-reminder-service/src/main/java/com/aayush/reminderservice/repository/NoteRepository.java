package com.aayush.reminderservice.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.reminderservice.entity.Note;

/**
 * Repository for the shared notes table.
 *
 * Provides:
 *   - findByIdAndUserId       : ownership check before setting/clearing reminder
 *   - findDueReminders        : scheduler query — notes past their reminder time that haven't fired yet
 */
public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<Note> findByIdAndUserId(Long id, Long userId);

    /**
     * Returns all notes whose reminderAt is before or at the given time
     * and whose reminderSent flag is still false.
     * Used by the scheduled task to find overdue reminders.
     */
    List<Note> findByReminderAtBeforeAndReminderSentFalse(LocalDateTime now);
}
