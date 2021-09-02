package com.hangarww.vaccination.repository;

import com.hangarww.vaccination.model.VaccinatedPerson;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VaccinatedPersonRepository extends MongoRepository<VaccinatedPerson, String> {
    Optional<VaccinatedPerson> findVaccinatedPersonByAadharIdAndVaccineGroupAndDoseGreaterThanEqual(String aadharId,
            String vaccineGroup, Integer dose);
}
