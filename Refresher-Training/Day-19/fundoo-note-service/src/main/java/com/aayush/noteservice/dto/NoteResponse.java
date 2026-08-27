package com.aayush.noteservice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoteResponse {

    private Long id;

    private String title;

    private String content;

    private Long userId;

    private boolean pinned;

    private boolean archived;

    private boolean trashed;

    private LocalDateTime reminderAt;

    private boolean reminderSent;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}