package com.aayush.reminderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.aayush.reminderservice.dto.ReminderRequest;
import com.aayush.reminderservice.dto.ReminderResponse;
import com.aayush.reminderservice.service.ReminderService;

import jakarta.validation.Valid;

/**
 * REST controller for reminder operations.
 *
 * All endpoints are JWT-protected (see SecurityConfig).
 * The user's id is taken from the Authentication principal (JWT subject).
 *
 * Endpoints:
 *   POST   /api/reminders/{noteId}  → set a reminder on a note
 *   DELETE /api/reminders/{noteId}  → clear the reminder from a note
 *   GET    /api/reminders/{noteId}  → get the current reminder for a note
 *
 * The note must belong to the authenticated user; otherwise a 404 is returned
 * to avoid leaking the existence of other users' notes.
 */
@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    /**
     * Sets (or updates) a reminder on the specified note.
     *
     * Request body: { "reminderAt": "2026-09-01T08:30:00" }
     *
     * Returns 200 with the updated reminder state.
     */
    @PostMapping("/{noteId}")
    public ResponseEntity<ReminderResponse> setReminder(
            @PathVariable Long noteId,
            @Valid @RequestBody ReminderRequest request,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                reminderService.setReminder(noteId, userId, request)
        );
    }

    /**
     * Clears the reminder from the specified note.
     *
     * Sets reminderAt = null and reminderSent = false.
     * Returns 200 with the updated (reminder-less) note state.
     */
    @DeleteMapping("/{noteId}")
    public ResponseEntity<ReminderResponse> clearReminder(
            @PathVariable Long noteId,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                reminderService.clearReminder(noteId, userId)
        );
    }

    /**
     * Returns the current reminder state of a note.
     *
     * Useful to check whether a reminder is set and whether it has already fired.
     */
    @GetMapping("/{noteId}")
    public ResponseEntity<ReminderResponse> getReminder(
            @PathVariable Long noteId,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                reminderService.getReminder(noteId, userId)
        );
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Helper
    // ──────────────────────────────────────────────────────────────────────────

    /**
     * Extracts the userId from the Spring Security Authentication.
     * The name is the JWT subject, which auth-service stores as the user's Long id.
     */
    private Long getUserId(Authentication authentication) {
        return Long.valueOf(authentication.getName());
    }
}
