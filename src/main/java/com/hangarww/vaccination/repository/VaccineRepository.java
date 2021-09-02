package com.hangarww.vaccination.repository;

import com.hangarww.vaccination.model.Vaccine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VaccineRepository extends MongoRepository<Vaccine, String> {

}
