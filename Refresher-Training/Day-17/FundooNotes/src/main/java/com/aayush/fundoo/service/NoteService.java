package com.aayush.fundoo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.fundoo.dto.NoteRequest;
import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.entity.Tag;
import com.aayush.fundoo.entity.User;
import com.aayush.fundoo.notification.NoteCreatedEvent;
import com.aayush.fundoo.repository.NoteRepository;
import com.aayush.fundoo.repository.TagRepository;
import com.aayush.fundoo.repository.UserRepository;

@Service
public class NoteService {
	private final NoteRepository noteRepository;
	private final UserRepository userRepository;
	private final TagRepository tagRepository;
	private final ApplicationEventPublisher eventPublisher;



	public NoteService(NoteRepository noteRepository, UserRepository userRepository, TagRepository tagRepository,
			ApplicationEventPublisher eventPublisher) {
		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
		this.tagRepository = tagRepository;
		this.eventPublisher = eventPublisher;
	}

	//creating note method
	@Transactional
	public Note createNote(NoteRequest request, String email) {
		// Creates a note and links it to the user identified by the JWT email.

		User user = findUser(email);
		Note note = new Note();
		note.setTitle(request.getTitle().trim());
		note.setContent(request.getContent().trim());
		note.setUser(user);
		note.setTags(resolveTags(request.getTags(), user));
		Note savedNote = noteRepository.save(note);

		// Publishes a post-commit event so RabbitMQ receives only successfully saved notes.
		eventPublisher.publishEvent(new NoteCreatedEvent(
				savedNote.getId(), savedNote.getTitle(), email));
		return savedNote;

	}
	
	// deleting Notes method
	@Transactional
	public void deleteNote(Long noteId, String email) {
		// Deletes a note only after confirming that the token user owns it.
		noteRepository.delete(findOwnedNote(noteId, email));
	}

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
		if (request.getTags() != null) {
			note.setTags(resolveTags(request.getTags(), note.getUser()));
		}
		return noteRepository.save(note);
	}

	// Flips the pinned flag of a note owned by the logged-in user
	@Transactional
	public Note togglePin(Long noteId, String email) {
		Note note = findOwnedNote(noteId, email);
		note.setPinned(!note.isPinned());
		return noteRepository.save(note);
	}

	// Flips the archived flag of a note owned by the logged-in user
	@Transactional
	public Note toggleArchive(Long noteId, String email) {
		Note note = findOwnedNote(noteId, email);
		note.setArchived(!note.isArchived());
		return noteRepository.save(note);
	}

	// Flips the trashed flag of a note owned by the logged-in user
	@Transactional
	public Note toggelTrash(Long noteId, String email) {
		Note note = findOwnedNote(noteId, email);
		note.setTrashed(!note.isTrashed());
		return noteRepository.save(note);
	}

	// Sets (or clears, if reminderAt is null) the reminder time on a note owned by the logged-in user.
	// reminderSent is reset to false so a fresh reminder time will fire a fresh notification.
	@Transactional
	public Note setReminder(Long noteId, LocalDateTime reminderAt, String email) {
		Note note = findOwnedNote(noteId, email);
		note.setReminderAt(reminderAt);
		note.setReminderSent(false);
		return noteRepository.save(note);
	}


	// Searches the logged-in user's notes by a keyword in title OR content
	public List<Note> searchNote(String keyword, String email) {
		return noteRepository.findByUserEmailAndTitleContainingIgnoreCaseOrUserEmailAndContentContainingIgnoreCase(
				email, keyword, email, keyword);
	}

	// Filters the logged-in user's notes by archived/trashed state
	public List<Note> filterNotes(boolean archived, boolean trashed, String email) {
		return noteRepository.findByUserEmailAndArchivedAndTrashed(email, archived, trashed);
	}

	// Finds the database user represented by the authenticated email
	private User findUser(String email) {
		return userRepository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Authenticated user no longer exists"));
	}

	// Finds a note only when its ID and owner email both match
	private Note findOwnedNote(Long noteId, String email) {
		return noteRepository.findByIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found"));
	}

	// Turns tag names typed by the user into managed Tag entities
	private Set<Tag> resolveTags(Set<String> tagNames, User user) {
		Set<Tag> tags = new HashSet<>();
		if (tagNames == null) {
			return tags;
		}
		for (String rawName : tagNames) {
			String name = rawName.trim();
			if (name.isEmpty()) {
				continue;
			}
			Tag tag = tagRepository.findByNameIgnoreCaseAndUser(name, user)
					.orElseGet(() -> {
						Tag newTag = new Tag();
						newTag.setName(name);
						newTag.setUser(user);
						return tagRepository.save(newTag);
					});
			tags.add(tag);
		}
		return tags;
	}

}
