package com.hangarww.vaccination.service;

import com.hangarww.vaccination.exception.InvalidAadharCardException;
import com.hangarww.vaccination.model.AadharCard;
import com.hangarww.vaccination.repository.AadharCardRepository;
import com.hangarww.vaccination.utility.AadharCardUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AadharCardService {

    @Autowired
    private AadharCardRepository aadharCardRepository;

    public AadharCard isAadharIdValid(String aadharId) throws InvalidAadharCardException {
        if (!AadharCardUtils.isValidAadharNumber(aadharId)){
            throw new InvalidAadharCardException("Aadhar Id is invalid");
        }

        Optional<AadharCard> aadharCardOptional = aadharCardRepository.findById(aadharId);
        if (aadharCardOptional.isPresent()){
            return aadharCardOptional.get();
        }
        else{
            throw new InvalidAadharCardException("Aadhar Id not found");
        }
    }
}
