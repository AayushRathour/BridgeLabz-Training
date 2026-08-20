package com.aayush.fundoo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.fundoo.dto.NoteRequest;
import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.entity.User;
import com.aayush.fundoo.repository.NoteRepository;
import com.aayush.fundoo.repository.UserRepository;

@Service
// Contains note creation and safe note deletion business rules.
public class NoteService {
	private final NoteRepository noteRepository;
	private final UserRepository userRepository;

	public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
		// Receives the repositories used to save notes and identify their owner.
		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
	}

	// method for creating note
	@Transactional
	public Note createNote(NoteRequest request, String email) {
		// Creates a note and links it to the user identified by the JWT email.

		Note note = new Note();
		note.setTitle(request.getTitle().trim());
		note.setContent(request.getContent().trim());
		note.setUser(findUser(email));
		return noteRepository.save(note);

	}

	@Transactional
	public void deleteNote(Long noteId, String email) {
		// Deletes a note only after confirming that the token user owns it.
		noteRepository.delete(findOwnedNote(noteId, email));
	}

	// NEW FOR NOTE CRUD -- START
	// method for listing all notes belonging to the logged-in user
	public List<Note> getUserNotes(String email) {
		// Returns every note owned by the authenticated email, newest first.
		return noteRepository.findAllByUserEmailOrderByIdDesc(email);
	}

	// method for fetching a single note owned by the logged-in user
	public Note getNote(Long noteId, String email) {
		// Finds one note only when it belongs to the authenticated email.
		return findOwnedNote(noteId, email);
	}

	// method for updating a note owned by the logged-in user
	@Transactional
	public Note updateNote(Long noteId, NoteRequest request, String email) {
		// Updates title/content only after confirming ownership of the note.
		Note note = findOwnedNote(noteId, email);
		note.setTitle(request.getTitle().trim());
		note.setContent(request.getContent().trim());
		return noteRepository.save(note);
	}
	// NEW FOR NOTE CRUD -- END

	private User findUser(String email) {
		// Finds the database user represented by the authenticated email.
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authenticated user no longer exists"));
	}

	private Note findOwnedNote(Long noteId, String email) {
		// Finds a note only when its ID and owner email both match.
		return noteRepository.findByIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));
	}

}
