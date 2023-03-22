package com.makaia.validator.services;

import com.makaia.validator.models.CsvDTO;
import com.makaia.validator.models.ExcelDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExcelService {
    public boolean validateExcel(ExcelDTO excelDTO){
        Set<String> reports = new HashSet<String>(Arrays.asList(
                "Near Miss", "Lost Time", "First Aid"));
        return reports.contains(excelDTO.getReportType()) && !excelDTO.getInjuryLocation().equals("N/A");
    }
}
