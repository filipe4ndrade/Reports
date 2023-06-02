package br.com.reports.entities.interfaces;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface FileReports {

//    Object getFileReports(Integer id);
    ByteArrayOutputStream getFileReports(Integer id);

    void generateFileReports(Object obj) throws IOException;

}
