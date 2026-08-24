package com.aayush.fundoo.batch;

import java.time.LocalDateTime;

// Holds one processed note row before Spring Batch writes it to Excel.
public record NoteExcelRow(
        // Mirrors the columns written into each row of the Notes worksheet.
        Long id,
        String title,
        String content,
        String tags,
        boolean pinned,
        boolean archived,
        boolean trashed,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime reminderAt) {
}
