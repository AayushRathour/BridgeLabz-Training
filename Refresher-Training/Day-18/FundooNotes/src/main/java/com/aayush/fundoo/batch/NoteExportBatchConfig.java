package com.aayush.fundoo.batch;

import java.util.stream.Collectors;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.repository.NoteRepository;

@Configuration
// Configures the chunk-oriented Spring Batch job used to export a user's notes.
public class NoteExportBatchConfig {

    @Bean
    // Registers the named job that contains the Excel export step.
    public Job noteExcelExportJob(JobRepository jobRepository, Step noteExcelExportStep) {
        return new JobBuilder("noteExcelExportJob", jobRepository)
                .start(noteExcelExportStep)
                .build();
    }

    @Bean
    // Builds a transactional chunk step that reads, transforms, and writes 100 notes at a time.
    public Step noteExcelExportStep(JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            ItemReader<Note> noteExportReader,
            ItemProcessor<Note, NoteExcelRow> noteExportProcessor,
            NoteExcelItemWriter noteExcelItemWriter) {
        return new StepBuilder("noteExcelExportStep", jobRepository)
                .<Note, NoteExcelRow>chunk(100, transactionManager)
                .reader(noteExportReader)
                .processor(noteExportProcessor)
                .writer(noteExcelItemWriter)
                .build();
    }

    @Bean
    @StepScope
    // Loads only the authenticated user's notes for this export job.
    public ListItemReader<Note> noteExportReader(
            @Value("#{jobParameters['email']}") String email,
            NoteRepository noteRepository) {
        return new ListItemReader<>(noteRepository.findAllByUserEmailOrderByIdDesc(email));
    }

    @Bean
    // Converts entities into Excel-safe rows and joins each note's tag names.
    public ItemProcessor<Note, NoteExcelRow> noteExportProcessor() {
        return note -> new NoteExcelRow(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getTags().stream().map(tag -> tag.getName()).sorted().collect(Collectors.joining(", ")),
                note.isPinned(),
                note.isArchived(),
                note.isTrashed(),
                note.getCreatedAt(),
                note.getUpdatedAt(),
                note.getReminderAt());
    }

    @Bean
    @StepScope
    // Creates a job-scoped writer so concurrent exports never share a workbook.
    public NoteExcelItemWriter noteExcelItemWriter(
            @Value("#{jobParameters['outputPath']}") String outputPath) {
        return new NoteExcelItemWriter(outputPath);
    }
}
