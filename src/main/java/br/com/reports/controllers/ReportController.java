package br.com.reports.controllers;

import br.com.reports.entities.enums.PaymentTypeEnum;
import br.com.reports.entities.enums.StatusEnum;
import br.com.reports.services.FileServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class ReportController {

    private final FileServiceFactory fileServiceFactory;




    @GetMapping("/report/{type}")
    public ResponseEntity<String> generateReport(@PathVariable String type,
                                                 @RequestParam(required = false) Integer clientId,
                                                 @RequestParam(required = false) StatusEnum status,
                                                 @RequestParam(required = false) LocalDate date,
                                                 @RequestParam(required = false) PaymentTypeEnum paymentType ) throws IOException {

             // String query = generatedQuery.generatedClient(type, clientId, status, date, paymentType);

              ByteArrayOutputStream reportOutputStream =  fileServiceFactory.getService(type).getFileReports(clientId);

              System.out.println(reportOutputStream.toString());



            return ResponseEntity.ok(reportOutputStream.toString());

    }


}