package com.hangarww.vaccination.repository;

import com.hangarww.vaccination.model.VaccinationCentre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VaccinationCentreRepository extends MongoRepository<VaccinationCentre, String> {

}
