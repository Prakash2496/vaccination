package com.hangarww.vaccination.controller;

import com.hangarww.vaccination.dto.VaccinationResponseDto;
import com.hangarww.vaccination.service.group.CovidVacinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/api/covid/1.0", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CovidVaccinationController {

    @Autowired
    private CovidVacinationService covidVacinationService;

    @GetMapping("/firstDose/{aadharId}")
    public VaccinationResponseDto getNearestVaccinationCentreFirstDose(@PathVariable String aadharId){
        return covidVacinationService.getNearestVaccinationCentreForFirstDose(aadharId);
    }

}
