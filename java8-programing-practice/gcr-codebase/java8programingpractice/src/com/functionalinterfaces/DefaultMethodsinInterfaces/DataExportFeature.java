package com.functionalinterfaces.DefaultMethodsinInterfaces;

interface ReportExporter {

    void exportCSV();
    void exportPDF();

    default void exportToJSON() {
        System.out.println("Exporting report to JSON");
    }
}

class ReportService implements ReportExporter {

    public void exportCSV() {
        System.out.println("CSV exported");
    }

    public void exportPDF() {
        System.out.println("PDF exported");
    }
}

public class DataExportFeature {
    public static void main(String[] args) {

        ReportExporter r = new ReportService();
        r.exportCSV();
        r.exportPDF();
        r.exportToJSON();
    }
}
