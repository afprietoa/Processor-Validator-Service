package com.makaia.processor.controllers;

import com.makaia.processor.models.Archive;
import com.makaia.processor.models.Tuple;
import com.makaia.processor.services.CsvService;
import com.makaia.processor.services.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CsvController {
    private CsvService csvService;

    @Autowired
    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @PostMapping("/processor")
    public Tuple validateTuples(@RequestBody Archive archive){
        return csvService.processCsVTuple(archive);
    }
}
