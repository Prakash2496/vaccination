package com.hangarww.vaccination.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "VaccinationCentres")
@Getter
@Setter
public class VaccinationCentre {

    @Id
    private String id;

    private String zipcode;

    private String name;

    private String location;

    public VaccinationCentre(){}

}
