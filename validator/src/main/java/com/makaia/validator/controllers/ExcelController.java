package com.makaia.validator.controllers;

import com.makaia.validator.models.ExcelDTO;
import com.makaia.validator.services.ExcelService;
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
    public ExcelController(ExcelService excelService){
        this.excelService = excelService;
    }
    @PostMapping("/validator")
    public boolean validateTuple(@RequestBody ExcelDTO excelDTO){
        return excelService.validateExcel(excelDTO);
    }
}
