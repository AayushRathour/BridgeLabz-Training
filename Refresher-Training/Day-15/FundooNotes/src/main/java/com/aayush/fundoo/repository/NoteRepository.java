package com.aayush.fundoo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.fundoo.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

    // Finds a note only when the ID and owner email both match.
    Optional<Note> findByIdAndUserEmail(Long id,String email);

    // gets all notes of the logged-in user.
    List<Note> findAllByUserEmailOrderByIdDesc(String email);

    // Searches title OR content for the logged-in user.
    List<Note> findByUserEmailAndTitleContainingIgnoreCaseOrUserEmailAndContentContainingIgnoreCase(
            String email1,
            String title,
            String email2,
            String content
    );

    //Filters notes by archived and trashed state.
    List<Note> findByUserEmailAndArchivedAndTrashed(
            String email,
            boolean archived,
            boolean trashed
    );

    // Finds every note (of one user) that carries a given tag name.
    List<Note> findByUserEmailAndTagsNameIgnoreCase(
            String email,
            String tagName
    );
}