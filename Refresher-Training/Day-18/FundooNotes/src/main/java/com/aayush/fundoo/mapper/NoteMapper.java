package com.aayush.fundoo.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aayush.fundoo.dto.NoteRequest;
import com.aayush.fundoo.dto.NoteResponse;
import com.aayush.fundoo.entity.Note;

@Component
public class NoteMapper {

	// Converts note input from the API into a new Note entity.
	public Note toEntity(NoteRequest request) {
		Note note = new Note();
		note.setTitle(request.getTitle().trim());
		note.setContent(request.getContent().trim());
		return note;
	}

	// Converts a Note entity into the safe data returned by the API.
	public NoteResponse toResponse(Note note) {
		NoteResponse response = new NoteResponse();
		response.setId(note.getId());
		response.setTitle(note.getTitle());
		response.setContent(note.getContent());
		response.setPinned(note.isPinned());
		response.setArchived(note.isArchived());
		response.setTrashed(note.isTrashed());
		response.setReminderAt(note.getReminderAt());
		response.setCreatedAt(note.getCreatedAt());
		response.setUpdatedAt(note.getUpdatedAt());
		response.setTags(note.getTags().stream().map(tag -> tag.getName()).collect(Collectors.toSet()));
		return response;
	}

	// Converts a list of Note entities into API response DTOs.
	public java.util.List<NoteResponse> toResponseList(java.util.List<Note> notes) {
		return notes.stream().map(this::toResponse).toList();
	}
}
