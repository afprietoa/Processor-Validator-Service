package com.makaia.processor.utils;

import com.makaia.processor.models.CsvDTO;
import com.makaia.processor.models.ExcelDTO;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ArchiveProcessor {
    public boolean processExcel(ExcelDTO excelDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ExcelDTO>  request = new HttpEntity<>(excelDTO);
        boolean response = restTemplate.postForObject("http://localhost:8090/api/v1/validator", request, boolean.class);
        return response;

    }
    public boolean processCsv(CsvDTO csvDTO){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<CsvDTO>  request = new HttpEntity<>(csvDTO);
        boolean response = restTemplate.postForObject("http://localhost:8090/api/v1/validator", request, boolean.class);
        return response;

    }

}
