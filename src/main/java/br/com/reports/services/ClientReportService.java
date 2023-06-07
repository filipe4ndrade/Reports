package br.com.reports.services;

import br.com.reports.configuration.file.FileService;
import br.com.reports.configuration.file.bytearray.ClientByteArray;
import br.com.reports.entities.interfaces.FileReports;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;

@RequiredArgsConstructor
@Service
public class ClientReportService implements FileReports {

    private final FileService fileService;
    private final ClientByteArray clientByteArray;


/*    @Override
    public ByteArrayOutputStream getFileReports(String type,Integer clientId, StatusEnum status, LocalDate date, PaymentType paymentType) {

   if (type != null) {
         return clientByteArray.findAll(id);
    }

    if (clientId != null) {
       return clientByteArray.findById(id);
    }

    if (status != null) {
        return clientByteArray.findById(id);
    }

    if (date != null) {

    }

    if (paymentType != null) {

    }


       return clientByteArray.findById(id);
    } */

    @Override
    public ByteArrayOutputStream getFileReports(Integer id) {
        return clientByteArray.findById(id);
    }

    @Override
    public void generateFileReports(Object obj) {
        fileService.generateFileClient(obj);
        System.out.println("Generating client file reports...");
    }
}
