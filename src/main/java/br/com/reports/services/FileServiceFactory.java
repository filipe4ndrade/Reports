package br.com.reports.services;

import br.com.reports.entities.enums.ReportTypeEnum;
import br.com.reports.entities.interfaces.FileReports;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class FileServiceFactory {

    private final Map<String, FileReports> services;

    public FileReports getService(String file) {
        ReportTypeEnum type = ReportTypeEnum.valueOf(file);
        return services.get(type.getService());
    }

}
