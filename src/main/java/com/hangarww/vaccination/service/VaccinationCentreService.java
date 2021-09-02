package com.hangarww.vaccination.service;

import com.hangarww.vaccination.dto.VaccinationMatchDto;
import com.hangarww.vaccination.exception.VaccineNotAvailableException;
import com.hangarww.vaccination.model.VaccinationCentre;
import com.hangarww.vaccination.model.Vaccine;
import com.hangarww.vaccination.model.VaccineAvailability;
import com.hangarww.vaccination.repository.VaccinationCentreRepository;
import com.hangarww.vaccination.repository.VaccineAvailabilityRepository;
import com.hangarww.vaccination.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Random;


@Service
public class VaccinationCentreService {
    @Autowired
    private VaccineAvailabilityRepository vaccineAvailabilityRepository;

    @Autowired
    private VaccinationCentreRepository vaccinationCentreRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    public VaccinationMatchDto getNearestVaccinationCentreByVaccineGroupAndDose(String vaccineGroup,Integer dose, String zipcode)
            throws VaccineNotAvailableException {

        List<VaccineAvailability> vaccineAvailabilityList =
                vaccineAvailabilityRepository.findAllByVaccineGroupAndDoseAndStatus(vaccineGroup,
                dose, true);

        List<VaccinationMatchDto> matchDtoList =
                vaccineAvailabilityList.stream().map(va -> VaccinationMatchDto.builder()
                .vaccinationCentreId(va.getVaccinationCentreId())
                .vaccineId(va.getVaccineId())
                .zipCode(vaccinationCentreRepository.findById(va.getVaccinationCentreId()).get().getZipcode())
                .build()
        ).collect(Collectors.toList());

        if(matchDtoList.isEmpty()){
            throw new VaccineNotAvailableException("No Vaccination Centres found for requested " + vaccineGroup + " "
                    + " vaccine dose "+ dose);
        }

        Optional<VaccinationMatchDto> nearestMatchOptional =
                matchDtoList.stream().filter(md -> md.getZipCode().equalsIgnoreCase(zipcode)).findFirst();

        return nearestMatchOptional.orElse(getNearestVaccinationCentre(matchDtoList, zipcode));
    }

    private VaccinationMatchDto getNearestVaccinationCentre(List<VaccinationMatchDto> matchDtoList, String zipcode){
        List<String> centres = matchDtoList.stream().map(VaccinationMatchDto::getZipCode).collect(Collectors.toList());

        Random randomMethod = new Random();
        int index = randomMethod.nextInt(centres.size());

        return matchDtoList.stream().filter(md -> md.getZipCode().equals(centres.get(index))).findFirst().orElse(null);
    }

    public Vaccine getVaccineById(String vaccineId){
        return vaccineRepository.findById(vaccineId).orElse(null);
    }

    public VaccinationCentre getVaccinationCentreById(String vaccinationCentreId){
        return vaccinationCentreRepository.findById(vaccinationCentreId).orElse(null);
    }

}
