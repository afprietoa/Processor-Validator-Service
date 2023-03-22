package com.makaia.validator.controllers;

import com.makaia.validator.models.CsvDTO;
import com.makaia.validator.services.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CsvController {
    private CsvService csvService;

    @Autowired
    public CsvController(CsvService csvService){
        this.csvService = csvService;
    }
    @PostMapping("/validator")
    public boolean validateTuple(@RequestBody CsvDTO csvDTO){
        return csvService.validateCsv(csvDTO);
    }

}
