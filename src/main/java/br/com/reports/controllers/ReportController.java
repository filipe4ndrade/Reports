package br.com.reports.controllers;

import br.com.reports.configuration.ClientDTO;
import br.com.reports.configuration.dao.ClientDAOJDBC;
import br.com.reports.entities.enums.PaymentTypeEnum;
import br.com.reports.entities.enums.StatusEnum;
import br.com.reports.entities.interfaces.FileReports;
import br.com.reports.services.ClientReportService;
import br.com.reports.services.FileServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class ReportController {

    private final FileServiceFactory fileServiceFactory;



    @GetMapping("/report/{type}")
    public ResponseEntity<String> generateReport(@PathVariable String type,
                                                 @RequestParam(required = false) Long clientId,
                                                 @RequestParam(required = false) StatusEnum status,
                                                 @RequestParam(required = false) LocalDate date,
                                                 @RequestParam(required = false) PaymentTypeEnum paymentType ){
        return ResponseEntity.ok(fileServiceFactory.getService(type).getFileReports());


    }


}