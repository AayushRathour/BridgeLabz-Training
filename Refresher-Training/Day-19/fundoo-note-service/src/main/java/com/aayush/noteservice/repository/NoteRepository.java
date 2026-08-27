package com.aayush.noteservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.noteservice.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserId(Long userId);

    Optional<Note> findByIdAndUserId(Long id, Long userId);

    List<Note> findByUserIdAndPinned(
            Long userId,
            boolean pinned
    );

    List<Note> findByUserIdAndArchived(
            Long userId,
            boolean archived
    );

    List<Note> findByUserIdAndTrashed(
            Long userId,
            boolean trashed
    );
}