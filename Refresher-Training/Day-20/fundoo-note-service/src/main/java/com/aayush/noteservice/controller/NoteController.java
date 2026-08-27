package com.aayush.noteservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.aayush.noteservice.dto.NoteRequest;
import com.aayush.noteservice.dto.NoteResponse;
import com.aayush.noteservice.service.NoteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(
            @Valid @RequestBody NoteRequest request,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.createNote(request, userId));
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getAllNotes(
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                noteService.getAllNotes(userId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> getNote(
            @PathVariable Long id,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                noteService.getNote(id, userId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequest request,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                noteService.updateNote(
                        id,
                        request,
                        userId
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(
            @PathVariable Long id,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        noteService.deleteNote(id, userId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/pin")
    public ResponseEntity<NoteResponse> pinNote(
            @PathVariable Long id,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                noteService.pinNote(id, userId)
        );
    }

    @PutMapping("/{id}/archive")
    public ResponseEntity<NoteResponse> archiveNote(
            @PathVariable Long id,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                noteService.archiveNote(id, userId)
        );
    }

    @PutMapping("/{id}/trash")
    public ResponseEntity<NoteResponse> trashNote(
            @PathVariable Long id,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                noteService.trashNote(id, userId)
        );
    }

    @PutMapping("/{id}/restore")
    public ResponseEntity<NoteResponse> restoreNote(
            @PathVariable Long id,
            Authentication authentication) {

        Long userId = getUserId(authentication);

        return ResponseEntity.ok(
                noteService.restoreNote(id, userId)
        );
    }

    private Long getUserId(Authentication authentication) {

        return Long.valueOf(authentication.getName());
    }
}