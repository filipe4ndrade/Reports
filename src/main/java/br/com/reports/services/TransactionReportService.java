package br.com.reports.services;

import br.com.reports.entities.interfaces.FileReports;
import org.springframework.stereotype.Service;

@Service
public class TransactionReportService implements FileReports {

    @Override
    public String getFileReports() {
        return "Info Transaction";
    }

    @Override
    public void generateFileReports() {
        System.out.println("Generating transaction file reports...");
    }
}
