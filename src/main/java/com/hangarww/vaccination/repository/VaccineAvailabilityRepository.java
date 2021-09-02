package com.hangarww.vaccination.repository;

import com.hangarww.vaccination.model.VaccineAvailability;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VaccineAvailabilityRepository extends MongoRepository<VaccineAvailability, String> {
    List<VaccineAvailability> findAllByVaccineGroupAndDoseAndStatus(String vaccineGroup,
            Integer dose,
            Boolean status);

}
