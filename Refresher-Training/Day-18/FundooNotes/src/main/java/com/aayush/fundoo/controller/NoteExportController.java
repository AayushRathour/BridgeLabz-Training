	package com.aayush.fundoo.controller;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.fundoo.service.NoteExportStorageService;

@RestController
@RequestMapping("/api/notes")
// Starts secure Spring Batch exports and serves the completed Excel files.
public class NoteExportController {

    // Starts the configured batch job when the export API is called.
    private final JobLauncher jobLauncher;
    // References the job that reads notes and writes the Excel workbook.
    private final Job noteExcelExportJob;
    // Builds and validates user-specific paths for exported files.
    private final NoteExportStorageService storageService;

    // Injects the batch launcher, export job, and protected file storage helper.
    public NoteExportController(JobLauncher jobLauncher, Job noteExcelExportJob,
            NoteExportStorageService storageService) {
        this.jobLauncher = jobLauncher;
        this.noteExcelExportJob = noteExcelExportJob;
        this.storageService = storageService;
    }

    @PostMapping("/export/excel")
    // Runs the authenticated user's note export in Spring Batch chunks of 100 records.
    public ResponseEntity<Map<String, Object>> exportNotes(Authentication authentication) {
        String email = authentication.getName(); // Gets the export owner from the JWT identity.
        String fileName = "notes-export-" + UUID.randomUUID() + ".xlsx"; // Prevents filename collisions.
        Path outputPath = storageService.createExportPath(email, fileName); // Keeps the file in that user's folder.

        try {
            JobExecution execution = jobLauncher.run(noteExcelExportJob, new JobParametersBuilder()
                    .addString("email", email)
                    .addString("outputPath", outputPath.toString())
                    .addLong("run.id", System.currentTimeMillis())
                    .toJobParameters());

            // Returns an error when Spring Batch fails or the expected file was not created.
            if (execution.getStatus() != BatchStatus.COMPLETED || !Files.exists(outputPath)) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Excel export job did not complete successfully");
            }

            // Reports the number of notes successfully written by all export steps.
            long exportedNotes = execution.getStepExecutions().stream()
                    .mapToLong(step -> step.getWriteCount())
                    .sum();
            return ResponseEntity.ok(Map.of(
                    "message", "Excel export created successfully",
                    "jobExecutionId", execution.getId(),
                    "exportedNotes", exportedNotes,
                    "fileName", fileName,
                    "downloadUrl", "/api/notes/exports/" + fileName));
        } catch (ResponseStatusException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not create Excel export", exception);
        }
    }

    @GetMapping("/exports/{fileName:.+}")
    // Downloads an export only when it belongs to the authenticated user.
    public ResponseEntity<Resource> downloadExport(@PathVariable String fileName, Authentication authentication) {
        Path path = storageService.resolveExportPath(authentication.getName(), fileName); // Verifies file ownership.
        if (!Files.isRegularFile(path)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Export file not found");
        }
        try {
            Resource resource = new UrlResource(path.toUri()); // Streams the local workbook without loading it all in memory.
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(
                            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            ContentDisposition.attachment().filename(fileName).build().toString())
                    .body(resource);
        } catch (MalformedURLException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Could not read Excel export", exception);
        }
    }
}
