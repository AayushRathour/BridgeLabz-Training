package com.aayush.noteservice.mapper;

import org.springframework.stereotype.Component;

import com.aayush.noteservice.dto.NoteRequest;
import com.aayush.noteservice.dto.NoteResponse;
import com.aayush.noteservice.entity.Note;

@Component
public class NoteMapper {

    public Note toEntity(NoteRequest request) {

        Note note = new Note();

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        return note;
    }

    public NoteResponse toResponse(Note note) {

        return NoteResponse.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .userId(note.getUserId())
                .pinned(note.isPinned())
                .archived(note.isArchived())
                .trashed(note.isTrashed())
                .reminderAt(note.getReminderAt())
                .reminderSent(note.isReminderSent())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }
}