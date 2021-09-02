package com.hangarww.vaccination.repository;

import com.hangarww.vaccination.model.AadharCard;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AadharCardRepository extends MongoRepository<AadharCard, String> {

}
