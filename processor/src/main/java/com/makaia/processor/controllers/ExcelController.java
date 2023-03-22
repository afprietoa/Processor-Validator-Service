package com.makaia.processor.controllers;

import com.makaia.processor.models.Archive;
import com.makaia.processor.services.CsvService;
import com.makaia.processor.models.Tuple;
import com.makaia.processor.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExcelController {
    private ExcelService excelService;

    @Autowired
    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/processor")
    public Tuple validateTuples(@RequestBody Archive archive){
        return excelService.processExcelTuple(archive);
    }
}
