package com.aayush.noteservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.noteservice.dto.NoteRequest;
import com.aayush.noteservice.dto.NoteResponse;
import com.aayush.noteservice.entity.Note;
import com.aayush.noteservice.mapper.NoteMapper;
import com.aayush.noteservice.repository.NoteRepository;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteService(
            NoteRepository noteRepository,
            NoteMapper noteMapper) {

        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    @Transactional
    public NoteResponse createNote(
            NoteRequest request,
            Long userId) {

        Note note = noteMapper.toEntity(request);

        note.setUserId(userId);

        Note savedNote = noteRepository.save(note);

        return noteMapper.toResponse(savedNote);
    }

    @Transactional(readOnly = true)
    public List<NoteResponse> getAllNotes(Long userId) {

        return noteRepository.findByUserId(userId)
                .stream()
                .map(noteMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public NoteResponse getNote(
            Long noteId,
            Long userId) {

        Note note = findUserNote(noteId, userId);

        return noteMapper.toResponse(note);
    }

    @Transactional
    public NoteResponse updateNote(
            Long noteId,
            NoteRequest request,
            Long userId) {

        Note note = findUserNote(noteId, userId);

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        Note updatedNote = noteRepository.save(note);

        return noteMapper.toResponse(updatedNote);
    }

    @Transactional
    public void deleteNote(
            Long noteId,
            Long userId) {

        Note note = findUserNote(noteId, userId);

        noteRepository.delete(note);
    }

    @Transactional
    public NoteResponse pinNote(
            Long noteId,
            Long userId) {

        Note note = findUserNote(noteId, userId);

        note.setPinned(!note.isPinned());

        return noteMapper.toResponse(
                noteRepository.save(note)
        );
    }

    @Transactional
    public NoteResponse archiveNote(
            Long noteId,
            Long userId) {

        Note note = findUserNote(noteId, userId);

        note.setArchived(!note.isArchived());

        return noteMapper.toResponse(
                noteRepository.save(note)
        );
    }

    @Transactional
    public NoteResponse trashNote(
            Long noteId,
            Long userId) {

        Note note = findUserNote(noteId, userId);

        note.setTrashed(true);

        return noteMapper.toResponse(
                noteRepository.save(note)
        );
    }

    @Transactional
    public NoteResponse restoreNote(
            Long noteId,
            Long userId) {

        Note note = findUserNote(noteId, userId);

        note.setTrashed(false);

        return noteMapper.toResponse(
                noteRepository.save(note)
        );
    }

    private Note findUserNote(
            Long noteId,
            Long userId) {

        return noteRepository
                .findByIdAndUserId(noteId, userId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                NOT_FOUND,
                                "Note not found"
                        ));
    }
}