package com.aayush.fundoo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aayush.fundoo.dto.NoteRequest;
import com.aayush.fundoo.dto.ReminderRequest;
import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.service.NoteService;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // List every note belonging to the logged-in user
    @GetMapping
    public List<Note> getAllNotes(Authentication authentication) {

        String email = authentication.getName();

        return noteService.getUserNotes(email);
    }

    // Get a single note owned by the logged-in user
    @GetMapping("/{id}")
    public Note getNote(
            @PathVariable Long id,
            Authentication authentication) {

        String email = authentication.getName();

        return noteService.getNote(id, email);
    }

    // Update the title/content (and optionally tags) of a note owned by the logged-in user
    @PutMapping("/{id}")
    public Note updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NoteRequest request,
            Authentication authentication) {

        String email = authentication.getName();

        return noteService.updateNote(id, request, email);
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
    
    // Add Pin endpoint
    @PutMapping("/{id}/pin")
    public Note togglePin(
    		@PathVariable Long id,
    		Authentication authentication) {
    	
    	String email = authentication.getName();
    	
    	return noteService.togglePin(id, email);
    }
    
    // Archives or unarchives the logged-in user's note
    @PutMapping("/{id}/archive")
    public Note toggleArchive( @PathVariable Long id, Authentication authentication) {
    	String email =authentication.getName();
    	return noteService.toggleArchive(id, email);
    }
    
    // Moves a note to trash or restores it
    @PutMapping("/{id}/trash")
    public Note toggelTrash(@PathVariable Long id, Authentication authentication) {
    	String email = authentication.getName();
    	
    	return noteService.toggelTrash(id, email);
    }
    
    // Sets (or clears, if reminderAt is null) a reminder time on a note.
    // A background job (ReminderScheduler) checks for due reminders and
    // delivers them asynchronously via JMS - this call itself is instant.
    @PutMapping("/{id}/reminder")
    public Note setReminder(
    		@PathVariable Long id,
    		@RequestBody ReminderRequest request,
    		Authentication authentication) {
    	
    	String email = authentication.getName();
    	
    	return noteService.setReminder(id, request.getReminderAt(), email);
    }
    
    // Added Search endpoint, Searches the logged-in user's notes by title or conten
    @GetMapping("/search")
    public List<Note> search(@RequestParam String keyword, Authentication authentication){
    	
    	String email = authentication.getName();
    	return noteService.searchNote(keyword, email);
    }
    
    //Filter endpoint, Filters the logged-in user's notes by archive and trash state
    @GetMapping("/filter")
    public List<Note> filter(
    		@RequestParam boolean archived, 
    		@RequestParam boolean trashed,
    		Authentication authentication){
    	
    	String email = authentication.getName();
    	
    	return noteService.filterNotes(archived, trashed, email);
    }
}