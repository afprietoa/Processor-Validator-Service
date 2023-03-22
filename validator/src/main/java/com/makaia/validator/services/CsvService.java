package com.makaia.validator.services;

import com.makaia.validator.models.CsvDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class CsvService {

    public boolean validateCsv(CsvDTO csvDTO){
        LocalDate MIN_DATE = LocalDate.of(1980,1,1);
        String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Set<String> jobs = new HashSet<String>(Arrays.asList(
                "Haematologist", "Phytotherapist", "Building surveyor"
                ,"Insurance", "account manager", "Educational psychologist"));
        return csvDTO.getEmail().matches(EMAIL_REGEX) && csvDTO.getDateOfBirth().isAfter(MIN_DATE) && jobs.contains(csvDTO.getJobTitle());
    }
}
