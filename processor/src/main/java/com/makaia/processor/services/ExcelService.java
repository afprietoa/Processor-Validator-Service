package com.makaia.processor.services;

import com.makaia.processor.models.Archive;
import com.makaia.processor.models.ExcelDTO;
import com.makaia.processor.models.Tuple;
import com.makaia.processor.utils.ArchiveProcessor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {
    private int validTupleCount=0;
    private int invalidTupleCount=0;
    private ArchiveProcessor archiveProcessor;

    @Autowired
    public ExcelService(ArchiveProcessor archiveProcessor){
        this.archiveProcessor = archiveProcessor;
    }

    public Tuple processExcelTuple(Archive archive) {

        List<ExcelDTO> list = readExcelTuple(archive.getPath());
        list.stream().skip(1)
                .forEach(tuple ->{
                    boolean isValid = archiveProcessor.processExcel(tuple);
                    if(isValid){
                        validTupleCount++;
                    }else{
                        invalidTupleCount++;
                    }
                });
        return new Tuple(validTupleCount, invalidTupleCount);
    }

    public List<ExcelDTO> readExcelTuple(String path){
        List<ExcelDTO> tupleList = new ArrayList<>();
        try{
            FileInputStream archive = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(archive);
            DataFormatter dataFormatter = new DataFormatter();
            Iterator<Sheet> sheets = workbook.sheetIterator();
            Sheet sheet2 = workbook.getSheetAt(0);
            int fields = sheet2.getRow(0).getLastCellNum();
            while(sheets.hasNext()){
                Sheet sheet = sheets.next();
                Iterator<Row> iterator = sheet.iterator();
                while(iterator.hasNext()){
                    Row row = iterator.next();
                    Iterator<Cell> cellIterator = row.iterator();
                    String[] cellValues = new String[fields];
                    int i=0;
                    while (cellIterator.hasNext()){
                        Cell cell = cellIterator.next();
                        String cellValue = dataFormatter.formatCellValue(cell);
                        cellValues[i] = cellValue;
                        i++;

                    }
                    ExcelDTO excelDTO = new ExcelDTO();
                    excelDTO.setDate(Double.parseDouble(cellValues[0]));
                    excelDTO.setInjuryLocation(cellValues[1]);
                    excelDTO.setGender(cellValues[2]);
                    excelDTO.setAgeGroup(cellValues[3]);
                    excelDTO.setIncidentType(cellValues[4]);
                    excelDTO.setDaysLost(Double.parseDouble(cellValues[5]));
                    excelDTO.setPlant(cellValues[6]);
                    excelDTO.setReportType(cellValues[7]);
                    excelDTO.setShift(cellValues[8]);
                    excelDTO.setDepartment(cellValues[9]);
                    excelDTO.setIncidentCost(Double.parseDouble(cellValues[10]));
                    excelDTO.setWkDay(cellValues[11]);
                    excelDTO.setMonth(Double.parseDouble(cellValues[12]));
                    excelDTO.setYear(Double.parseDouble(cellValues[13]));
                    tupleList.add(excelDTO);
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return tupleList;
    }
}
