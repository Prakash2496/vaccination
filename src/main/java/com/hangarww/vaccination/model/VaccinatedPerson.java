package com.hangarww.vaccination.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "VaccinatedPeople")
@Getter
@Setter
public class VaccinatedPerson {
    private String aadharId;
    private String vaccineId;
    private String vaccineGroup;
    private String vaccinationCentreId;
    private Integer dose;
    private Boolean fullyVaccinated;

    public VaccinatedPerson(){}

}
