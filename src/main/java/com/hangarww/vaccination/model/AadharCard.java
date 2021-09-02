package com.hangarww.vaccination.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AadharCards")
@Getter
@Setter
public class AadharCard {

    @Id
    private String id;
    private String name;
    private String address;
    private String zipcode;

    public AadharCard(){}

}
