package com.hangarww.vaccination.service.group;

import com.hangarww.vaccination.dto.VaccinationMatchDto;
import com.hangarww.vaccination.dto.VaccinationResponseDto;
import com.hangarww.vaccination.exception.InvalidAadharCardException;
import com.hangarww.vaccination.exception.VaccineNotAvailableException;
import com.hangarww.vaccination.model.AadharCard;
import com.hangarww.vaccination.model.VaccinationCentre;
import com.hangarww.vaccination.model.Vaccine;
import com.hangarww.vaccination.service.AadharCardService;
import com.hangarww.vaccination.service.VaccinationCentreService;
import com.hangarww.vaccination.service.VaccinationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidVacinationService {

    @Autowired
    private AadharCardService aadharCardService;

    @Autowired
    private VaccinationRequestService vaccinationRequestService;

    @Autowired
    private VaccinationCentreService vaccinationCentreService;

    private static final String COVID_VACCINE_GROUP = "covid";

    public VaccinationResponseDto getNearestVaccinationCentreForFirstDose(String aadharId){
        try {
            AadharCard aadharCard = validateAadharId(aadharId);
            if (isPersonTakingFirstDose(aadharCard.getId())){
                VaccinationMatchDto vaccinationMatchDto =
                        getVaccinationMatchByVaccineGroupAndFirstDose(aadharCard.getZipcode());

                Vaccine vaccine = vaccinationCentreService.getVaccineById(vaccinationMatchDto.getVaccineId());
                VaccinationCentre vaccinationCentre =
                        vaccinationCentreService.getVaccinationCentreById(vaccinationMatchDto.getVaccinationCentreId());

                return VaccinationResponseDto.builder()
                        .aadharId(aadharCard.getId())
                        .person(aadharCard.getName())
                        .vaccine(vaccine.getName())
                        .dose(1)
                        .vaccinationCentre(vaccinationCentre.getName())
                        .vaccinationLocation(vaccinationCentre.getLocation())
                        .statusOK(true)
                        .build();

            }
            return VaccinationResponseDto.builder()
                    .message("You have already been administered your first shot")
                    .statusOK(false)
                    .build();
        } catch (InvalidAadharCardException | VaccineNotAvailableException e ) {
            return VaccinationResponseDto.builder()
                    .message(e.getMessage())
                    .statusOK(false)
                    .build();
        }
    }

    public AadharCard validateAadharId(String aadharId) throws InvalidAadharCardException {
        return aadharCardService.isAadharIdValid(aadharId);
    }

    public boolean isPersonTakingFirstDose(String aadharId){
        return vaccinationRequestService.isPersonRequestingFirstDose(aadharId, COVID_VACCINE_GROUP);
    }

    public VaccinationMatchDto getVaccinationMatchByVaccineGroupAndFirstDose(String zipcode)
            throws VaccineNotAvailableException {
        return vaccinationCentreService.getNearestVaccinationCentreByVaccineGroupAndDose(COVID_VACCINE_GROUP,1,
                zipcode);
    }



}
