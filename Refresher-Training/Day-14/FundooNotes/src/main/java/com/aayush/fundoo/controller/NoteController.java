package com.aayush.fundoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aayush.fundoo.dto.NoteRequest;
import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.service.NoteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {

        this.noteService = noteService;
    }

    // Create a note for the logged-in user
    @PostMapping
    public Note createNote(
            @Valid @RequestBody NoteRequest request,
            Authentication authentication) {

        // Email comes from the authenticated JWT
        String email = authentication.getName();

        return noteService.createNote(request, email);
    }

    // Delete a note owned by the logged-in user
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(
            @PathVariable Long id,
            Authentication authentication) {

        // Email comes from the authenticated JWT
        String email = authentication.getName();

        noteService.deleteNote(id, email);
    }
}