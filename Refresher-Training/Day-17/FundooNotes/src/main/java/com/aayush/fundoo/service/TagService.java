package com.aayush.fundoo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.entity.Tag;
import com.aayush.fundoo.entity.User;
import com.aayush.fundoo.repository.NoteRepository;
import com.aayush.fundoo.repository.TagRepository;
import com.aayush.fundoo.repository.UserRepository;

@Service
public class TagService {

	private final TagRepository tagRepository;
	private final NoteRepository noteRepository;
	private final UserRepository userRepository;

	public TagService(TagRepository tagRepository, NoteRepository noteRepository, UserRepository userRepository) {
		this.tagRepository = tagRepository;
		this.noteRepository = noteRepository;
		this.userRepository = userRepository;
	}

	// Adds a tag to a note owned by the logged-in user, creating the tag if it doesn't exist yet
	@Transactional
	public Note addTagToNote(Long noteId, String tagName, String email) {
		if (tagName == null || tagName.trim().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tag name cannot be empty");
		}
		User user = findUser(email);
		Note note = findOwnedNote(noteId, email);
		Tag tag = findOrCreateTag(tagName.trim(), user);
		note.getTags().add(tag);
		return noteRepository.save(note);
	}

	// Removes a tag from a note owned by the logged-in user
	@Transactional
	public Note removeTagFromNote(Long noteId, String tagName, String email) {
		User user = findUser(email);
		Note note = findOwnedNote(noteId, email);
		Tag tag = tagRepository.findByNameIgnoreCaseAndUser(tagName.trim(), user)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag not found"));
		note.getTags().remove(tag);
		return noteRepository.save(note);
	}

	// Lists every tag/label the logged-in user has created
	public List<Tag> getUserTags(String email) {
		return tagRepository.findAllByUserOrderByNameAsc(findUser(email));
	}

	// Lists every note (of the logged-in user) that carries the given tag
	public List<Note> getNotesByTag(String tagName, String email) {
		return noteRepository.findByUserEmailAndTagsNameIgnoreCase(email, tagName.trim());
	}

	// Finds an existing tag for this user by name, or creates a new one
	private Tag findOrCreateTag(String name, User user) {
		return tagRepository.findByNameIgnoreCaseAndUser(name, user)
				.orElseGet(() -> {
					Tag tag = new Tag();
					tag.setName(name);
					tag.setUser(user);
					return tagRepository.save(tag);
				});
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
}
