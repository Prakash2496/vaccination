package com.hangarww.vaccination.service;

import com.hangarww.vaccination.repository.VaccinatedPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationRequestService {

    @Autowired
    VaccinatedPersonRepository vaccinatedPersonRepository;

    public boolean isPersonRequestingFirstDose(String aadharId, String vaccineGroup){
        return vaccinatedPersonRepository.findVaccinatedPersonByAadharIdAndVaccineGroupAndDoseGreaterThanEqual(aadharId,
                vaccineGroup,1).isEmpty();
    }

}
