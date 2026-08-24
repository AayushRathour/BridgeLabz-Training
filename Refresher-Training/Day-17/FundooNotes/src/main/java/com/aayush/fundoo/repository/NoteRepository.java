package com.aayush.fundoo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph;

import com.aayush.fundoo.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

    // Fetches tags with note queries so JSON responses work after the database session closes.

    // Finds a note only when the ID and owner email both match.
    @EntityGraph(attributePaths = "tags")
    Optional<Note> findByIdAndUserEmail(Long id,String email);

    // gets all notes of the logged-in user.
    @EntityGraph(attributePaths = "tags")
    List<Note> findAllByUserEmailOrderByIdDesc(String email);

    // Searches title OR content for the logged-in user.
    @EntityGraph(attributePaths = "tags")
    List<Note> findByUserEmailAndTitleContainingIgnoreCaseOrUserEmailAndContentContainingIgnoreCase(
            String email1,
            String title,
            String email2,
            String content
    );

    //Filters notes by archived and trashed state.
    @EntityGraph(attributePaths = "tags")
    List<Note> findByUserEmailAndArchivedAndTrashed(
            String email,
            boolean archived,
            boolean trashed
    );

    // Finds every note (of one user) that carries a given tag name.
    @EntityGraph(attributePaths = "tags")
    List<Note> findByUserEmailAndTagsNameIgnoreCase(
            String email,
            String tagName
    );

    // Finds every note whose reminder time has passed but hasn't been notified yet.
    // Used by the reminder scheduler (Day 16 - JMS Reminder & Notification module).
    List<Note> findByReminderAtLessThanEqualAndReminderSentFalse(LocalDateTime now);
}
