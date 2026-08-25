package com.aayush.fundoo.batch;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.repository.NoteRepository;

@Component
public class NoteExcelExportTasklet implements Tasklet {

    private final NoteRepository noteRepository;

    public NoteExcelExportTasklet(
            NoteRepository noteRepository) {

        this.noteRepository = noteRepository;
    }

    @Override
    public RepeatStatus execute(
            StepContribution contribution,
            ChunkContext chunkContext)
            throws Exception {

        /*
         * Read the logged-in user's email from
         * Spring Batch JobParameters.
         */
        String userEmail =
                chunkContext
                        .getStepContext()
                        .getJobParameters()
                        .get("userEmail")
                        .toString();

        /*
         * Read the output Excel file path
         * from Spring Batch JobParameters.
         */
        String outputFile =
                chunkContext
                        .getStepContext()
                        .getJobParameters()
                        .get("outputFile")
                        .toString();

        /*
         * Fetch only this user's notes.
         */
        List<Note> notes =
                noteRepository
                        .findAllByUserEmailOrderByIdDesc(
                                userEmail
                        );

        /*
         * Create Excel workbook.
         */
        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet =
                    workbook.createSheet("Notes");

            /*
             * Create Excel header.
             */
            Row header =
                    sheet.createRow(0);

            header.createCell(0)
                    .setCellValue("ID");

            header.createCell(1)
                    .setCellValue("Title");

            header.createCell(2)
                    .setCellValue("Content");

            header.createCell(3)
                    .setCellValue("Created At");

            header.createCell(4)
                    .setCellValue("Updated At");

            header.createCell(5)
                    .setCellValue("Pinned");

            header.createCell(6)
                    .setCellValue("Archived");

            header.createCell(7)
                    .setCellValue("Trashed");

            header.createCell(8)
                    .setCellValue("Tags");


            /*
             * Add notes to Excel.
             */
            int rowNumber = 1;

            for (Note note : notes) {

                Row row = sheet.createRow(rowNumber++);

                row.createCell(0).setCellValue(note.getId());

                row.createCell(1).setCellValue(note.getTitle());

                row.createCell(2).setCellValue(note.getContent());

                row.createCell(3)
                        .setCellValue(
                                note.getCreatedAt()
                                        .toString()
                        );

                row.createCell(4)
                        .setCellValue(
                                note.getUpdatedAt()
                                        .toString()
                        );

                row.createCell(5)
                        .setCellValue(
                                note.isPinned()
                        );

                row.createCell(6)
                        .setCellValue(
                                note.isArchived()
                        );

                row.createCell(7)
                        .setCellValue(
                                note.isTrashed()
                        );

                String tags =
                        note.getTags()
                                .stream()
                                .map(tag -> tag.getName())
                                .collect(
                                        Collectors.joining(", ")
                                );

                row.createCell(8)
                        .setCellValue(tags);
            }


            /*
             * Make columns readable.
             */
            for (int i = 0; i <= 8; i++) {
                sheet.autoSizeColumn(i);
            }


            /*
             * Create the export directory
             * if it does not exist.
             */
            Path outputPath =
                    Paths.get(outputFile);

            Files.createDirectories(
                    outputPath.getParent()
            );


            /*
             * Write workbook to disk.
             */
            try (FileOutputStream outputStream =
                         new FileOutputStream(
                                 outputPath.toFile()
                         )) {

                workbook.write(outputStream);
            }
        }

        /*
         * Tell Spring Batch that the step is complete.
         */
        return RepeatStatus.FINISHED;
    }
}