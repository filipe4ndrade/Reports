package br.com.reports.entities.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportTypeEnum {

    CLIENT("clientReportService"),
    TRANSACTION("transactionReportService");


    private final String service;


}
