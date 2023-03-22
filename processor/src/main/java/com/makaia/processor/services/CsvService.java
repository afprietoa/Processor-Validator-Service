package com.makaia.processor.services;

import com.makaia.processor.models.*;
import com.makaia.processor.utils.ArchiveProcessor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CsvService {
    private int validTupleCount=0;
    private int invalidTupleCount=0;

    private ArchiveProcessor archiveProcessor;

    @Autowired
    public CsvService(ArchiveProcessor archiveProcessor){
        this.archiveProcessor = archiveProcessor;
    }

    public Tuple processCsVTuple(Archive archive) {

        List<CsvDTO> list = readCsVTuple(archive.getPath());
        list.stream().skip(1)
                .forEach(tuple ->{
                    boolean isValid = archiveProcessor.processCsv(tuple);
                    if(isValid){
                        validTupleCount++;
                    }else{
                        invalidTupleCount++;
                    }
                });
        return new Tuple(validTupleCount, invalidTupleCount);
    }



    public List<CsvDTO> readCsVTuple(String path){
        String tuple;
        List<CsvDTO> tupleList = new ArrayList<>();
        try (BufferedReader buffer =
                     new BufferedReader(new FileReader(path))) {
            while((tuple = buffer.readLine()) != null){
                String[] cellValues = tuple.split(",");
                CsvDTO csvDTO = new CsvDTO();
                csvDTO.setIndex(Integer.parseInt(cellValues[0]));
                csvDTO.setUserId(cellValues[1]);
                csvDTO.setFirstName(cellValues[2]);
                csvDTO.setLastName(cellValues[3]);
                csvDTO.setSex(cellValues[4]);
                csvDTO.setEmail(cellValues[5]);
                csvDTO.setPhone(cellValues[6]);
                String[]  ddmmyy = cellValues[7].split("-");
                csvDTO.setDateOfBirth(
                        LocalDate.of( Integer.parseInt(ddmmyy[0]),
                                      Integer.parseInt(ddmmyy[1]),
                                      Integer.parseInt(ddmmyy[2])));
                csvDTO.setJobTitle(cellValues[8]);
                tupleList.add(csvDTO);
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return tupleList;
    }

}
