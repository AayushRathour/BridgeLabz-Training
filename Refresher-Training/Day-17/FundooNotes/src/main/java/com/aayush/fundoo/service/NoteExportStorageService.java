package com.aayush.fundoo.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
// Keeps exported files in separate, non-guessable folders for each user.
public class NoteExportStorageService {

    // Stores the normalized base directory configured for all Excel exports.
    private final Path exportRoot;

    // Converts the configured export directory into a safe absolute path once.
    public NoteExportStorageService(@Value("${app.exports.directory}") String exportDirectory) {
        this.exportRoot = Path.of(exportDirectory).toAbsolutePath().normalize();
    }

    // Builds the safe output path used by one unique batch export.
    public Path createExportPath(String email, String fileName) {
        return userDirectory(email).resolve(fileName).normalize();
    }

    // Resolves a requested file only inside the authenticated user's export folder.
    public Path resolveExportPath(String email, String fileName) {
        if (!fileName.matches("notes-export-[a-f0-9-]+\\.xlsx")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Export file not found");
        }
        Path path = userDirectory(email).resolve(fileName).normalize();
        if (!path.startsWith(userDirectory(email))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Export file not found");
        }
        return path;
    }

    // Uses a SHA-256 email hash so folder names do not expose user email addresses.
    private Path userDirectory(String email) {
        return exportRoot.resolve(sha256(email)).normalize();
    }

    // Produces the stable hexadecimal folder identifier used for one user.
    private String sha256(String value) {
        try {
            byte[] hash = MessageDigest.getInstance("SHA-256").digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder output = new StringBuilder();
            for (byte item : hash) {
                output.append(String.format("%02x", item));
            }
            return output.toString();
        } catch (NoSuchAlgorithmException exception) {
            throw new IllegalStateException("SHA-256 is unavailable", exception);
        }
    }
}
