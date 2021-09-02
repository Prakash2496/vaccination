package com.hangarww.vaccination.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "VaccineAvailabilities")
@Getter
@Setter
public class VaccineAvailability {
    private String vaccineId;
    private String vaccineGroup;
    private String vaccinationCentreId;
    private Integer dose;
    private Boolean status;

    public VaccineAvailability(){}
}
