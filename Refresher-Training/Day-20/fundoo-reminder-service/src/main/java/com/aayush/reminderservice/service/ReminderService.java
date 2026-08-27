package com.aayush.reminderservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.reminderservice.dto.ReminderRequest;
import com.aayush.reminderservice.dto.ReminderResponse;
import com.aayush.reminderservice.entity.Note;
import com.aayush.reminderservice.repository.NoteRepository;

/**
 * Reminder business logic.
 *
 * REST operations:
 *   setReminder(noteId, userId, request)   → save reminderAt, reset reminderSent
 *   clearReminder(noteId, userId)           → null out reminderAt, reset reminderSent
 *   getReminder(noteId, userId)             → read current reminder state
 *
 * Scheduled operation:
 *   processReminders()   → runs every N ms (configured via reminder.scheduler.fixed-rate-ms),
 *                           finds overdue reminders, logs/notifies, marks reminderSent = true.
 *
 * NOTE: In a production system the scheduler would publish an event to a message broker
 * (e.g., Kafka / RabbitMQ) so a notification service can send an email/push notification.
 * For this training project it logs the fired reminders instead.
 */
@Service
public class ReminderService {

    private static final Logger log = LoggerFactory.getLogger(ReminderService.class);

    private final NoteRepository noteRepository;

    // Injected so we can log the configured rate in startup
    @Value("${reminder.scheduler.fixed-rate-ms:60000}")
    private long fixedRateMs;

    public ReminderService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // ──────────────────────────────────────────────────────────────────────────
    // REST operations
    // ──────────────────────────────────────────────────────────────────────────

    /**
     * Sets (or updates) the reminder time on a note owned by the caller.
     *
     * Resets reminderSent to false so a re-scheduled reminder fires again.
     */
    @Transactional
    public ReminderResponse setReminder(
            Long noteId,
            Long userId,
            ReminderRequest request) {

        Note note = findUserNote(noteId, userId);

        note.setReminderAt(request.getReminderAt());
        note.setReminderSent(false);   // reset so the scheduler will fire it

        return toResponse(noteRepository.save(note));
    }

    /**
     * Clears the reminder from a note owned by the caller.
     * After this call reminderAt = null and reminderSent = false.
     */
    @Transactional
    public ReminderResponse clearReminder(Long noteId, Long userId) {

        Note note = findUserNote(noteId, userId);

        note.setReminderAt(null);
        note.setReminderSent(false);

        return toResponse(noteRepository.save(note));
    }

    /**
     * Returns the current reminder state for a note owned by the caller.
     */
    @Transactional(readOnly = true)
    public ReminderResponse getReminder(Long noteId, Long userId) {

        Note note = findUserNote(noteId, userId);

        return toResponse(note);
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Scheduler
    // ──────────────────────────────────────────────────────────────────────────

    /**
     * Scheduled task that runs every N milliseconds (see reminder.scheduler.fixed-rate-ms).
     *
     * Finds all notes whose:
     *   - reminderAt <= now  (the time has passed)
     *   - reminderSent = false  (not already processed)
     *
     * For each overdue note it:
     *   1. Logs a WARN message (in production: publish to a notification queue).
     *   2. Marks reminderSent = true so the reminder is not fired again.
     *
     * The @Scheduled fixedRateString is read from application.yml.
     */
    @Scheduled(fixedRateString = "${reminder.scheduler.fixed-rate-ms:60000}")
    @Transactional
    public void processReminders() {

        LocalDateTime now = LocalDateTime.now();

        List<Note> dueNotes =
                noteRepository.findByReminderAtBeforeAndReminderSentFalse(now);

        if (dueNotes.isEmpty()) {
            return;
        }

        log.info("[ReminderScheduler] Found {} due reminder(s) at {}", dueNotes.size(), now);

        for (Note note : dueNotes) {

            // ─── In production: publish ReminderFiredEvent to message broker ───
            // eventPublisher.publish(new ReminderFiredEvent(note.getId(), note.getUserId()));
            // ────────────────────────────────────────────────────────────────────

            log.warn("[ReminderScheduler] REMINDER FIRED → noteId={}, userId={}, title='{}', scheduledAt={}",
                    note.getId(),
                    note.getUserId(),
                    note.getTitle(),
                    note.getReminderAt());

            note.setReminderSent(true);
        }

        // Batch-save all updated notes
        noteRepository.saveAll(dueNotes);

        log.info("[ReminderScheduler] Marked {} note(s) as reminderSent=true", dueNotes.size());
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Private helpers
    // ──────────────────────────────────────────────────────────────────────────

    /**
     * Looks up a note by id AND userId to enforce ownership.
     * Throws 404 if not found (either doesn't exist or belongs to another user).
     */
    private Note findUserNote(Long noteId, Long userId) {
        return noteRepository
                .findByIdAndUserId(noteId, userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Note not found or does not belong to you"
                ));
    }

    /**
     * Maps a Note entity to a ReminderResponse DTO.
     */
    private ReminderResponse toResponse(Note note) {
        return ReminderResponse.builder()
                .noteId(note.getId())
                .title(note.getTitle())
                .reminderAt(note.getReminderAt())
                .reminderSent(note.isReminderSent())
                .updatedAt(note.getUpdatedAt())
                .build();
    }
}
