package com.aayush.fundoo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aayush.fundoo.entity.Tag;
import com.aayush.fundoo.dto.NoteResponse;
import com.aayush.fundoo.mapper.NoteMapper;
import com.aayush.fundoo.service.TagService;

@RestController
@RequestMapping("/api/notes")
public class TagController {

    private final TagService tagService;
    private final NoteMapper noteMapper;

    public TagController(TagService tagService, NoteMapper noteMapper) {
        // Receives the service that contains tag business logic.
        this.tagService = tagService;
        this.noteMapper = noteMapper;
    }

    // Adds a tag to a note (creates the tag if it's new). Body: {"name": "work"}
    @PostMapping("/{id}/tags")
    public NoteResponse addTag(
            @PathVariable Long id,
            @RequestBody Map<String, String> body,
            Authentication authentication) {

        String email = authentication.getName();
        return noteMapper.toResponse(tagService.addTagToNote(id, body.get("name"), email));
    }

    // Removes a tag from a note
    @DeleteMapping("/{id}/tags/{tagName}")
    public NoteResponse removeTag(
            @PathVariable Long id,
            @PathVariable String tagName,
            Authentication authentication) {

        String email = authentication.getName();
        return noteMapper.toResponse(tagService.removeTagFromNote(id, tagName, email));
    }

    // Lists every tag/label the logged-in user has created
    @GetMapping("/tags")
    public List<Tag> myTags(Authentication authentication) {
        return tagService.getUserTags(authentication.getName());
    }

    // Lists every note (of the logged-in user) that carries the given tag
    @GetMapping("/tags/{tagName}")
    public List<NoteResponse> notesByTag(
            @PathVariable String tagName,
            Authentication authentication) {

        return noteMapper.toResponseList(tagService.getNotesByTag(tagName, authentication.getName()));
    }
}
