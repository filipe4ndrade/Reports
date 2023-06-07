package br.com.reports.services;

import br.com.reports.configuration.file.FileService;
import br.com.reports.configuration.file.bytearray.TransactionByteArray;
import br.com.reports.entities.interfaces.FileReports;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;

@RequiredArgsConstructor
@Service
public class TransactionReportService implements FileReports {

    private final FileService fileService;
    private final TransactionByteArray transactionByteArray;

    @Override
    public ByteArrayOutputStream getFileReports(Integer id) {

        return transactionByteArray.findById(id);
    }
    @Override
    public void generateFileReports(Object obj){
        fileService.generateFileTransaction(obj);
        System.out.println("Generating client file reports...");

    }
}
