package com.aayush.fundoo.batch;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

// Writes processed note rows to one Excel workbook during a batch step.
public class NoteExcelItemWriter implements ItemStreamWriter<NoteExcelRow> {

    // Uses one readable date format for all Excel timestamp columns.
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // Identifies the user-specific .xlsx file created by this job execution.
    private final Path outputPath;
    // Keeps the workbook open while Spring Batch delivers chunks to this writer.
    private XSSFWorkbook workbook;
    // Represents the single Notes sheet inside the generated workbook.
    private XSSFSheet sheet;
    // Tracks the next spreadsheet row after the header row.
    private int rowNumber;

    // Receives the output path from the job-scoped Spring Batch configuration.
    public NoteExcelItemWriter(String outputPath) {
        this.outputPath = Path.of(outputPath);
    }

    @Override
    // Opens a fresh workbook and prepares its header before the first chunk arrives.
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        try {
            Files.createDirectories(outputPath.getParent());
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Notes");
            createHeader();
            rowNumber = 1;
        } catch (IOException exception) {
            throw new ItemStreamException("Could not create Excel export", exception);
        }
    }

    @Override
    // Writes every processed note in the current Spring Batch chunk to Excel.
    public void write(Chunk<? extends NoteExcelRow> items) {
        for (NoteExcelRow item : items) {
            Row row = sheet.createRow(rowNumber++);
            put(row, 0, String.valueOf(item.id()));
            put(row, 1, item.title());
            put(row, 2, item.content());
            put(row, 3, item.tags());
            put(row, 4, String.valueOf(item.pinned()));
            put(row, 5, String.valueOf(item.archived()));
            put(row, 6, String.valueOf(item.trashed()));
            put(row, 7, format(item.createdAt()));
            put(row, 8, format(item.updatedAt()));
            put(row, 9, format(item.reminderAt()));
        }
    }

    @Override
    // Finalizes the workbook and writes the completed .xlsx file to disk.
    public void close() throws ItemStreamException {
        if (workbook == null) {
            return;
        }
        XSSFWorkbook currentWorkbook = workbook;
        try (OutputStream output = Files.newOutputStream(outputPath); currentWorkbook) {
            sheet.setColumnWidth(0, 12 * 256);
            sheet.setColumnWidth(1, 28 * 256);
            sheet.setColumnWidth(2, 48 * 256);
            sheet.setColumnWidth(3, 24 * 256);
            for (int index = 4; index < 10; index++) {
                sheet.setColumnWidth(index, 20 * 256);
            }
            currentWorkbook.write(output);
        } catch (IOException exception) {
            throw new ItemStreamException("Could not save Excel export", exception);
        } finally {
            workbook = null;
        }
    }

    // Creates bold column headings and freezes them while users scroll the sheet.
    private void createHeader() {
        String[] headers = { "ID", "Title", "Content", "Tags", "Pinned", "Archived", "Trashed",
                "Created At", "Updated At", "Reminder At" };
        Font font = workbook.createFont();
        font.setBold(true);
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);
        Row header = sheet.createRow(0);
        for (int index = 0; index < headers.length; index++) {
            Cell cell = header.createCell(index);
            cell.setCellValue(headers[index]);
            cell.setCellStyle(style);
        }
        sheet.createFreezePane(0, 1);
    }

    // Writes an empty cell instead of null so every Excel row stays valid.
    private void put(Row row, int column, String value) {
        row.createCell(column).setCellValue(value == null ? "" : value);
    }

    // Converts optional Java date-time values into the workbook date format.
    private String format(java.time.LocalDateTime value) {
        return value == null ? "" : DATE_FORMAT.format(value);
    }
}
