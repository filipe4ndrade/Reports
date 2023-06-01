package br.com.reports.services;


import br.com.reports.configuration.dao.ClientDAOJDBC;
import br.com.reports.entities.interfaces.FileReports;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientReportService implements FileReports {

    private final ClientDAOJDBC clientDAOJDBC;



    @Override
    public String getFileReports() {
        return clientDAOJDBC.findById(4).toString();
    }

    @Override
    public void generateFileReports() {
        System.out.println("Generating client file reports...");
    }
}
