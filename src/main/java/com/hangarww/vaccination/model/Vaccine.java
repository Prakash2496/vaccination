package com.hangarww.vaccination.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vaccines")
@Getter
@Setter
public class Vaccine {
    @Id
    private String id;
    private String name;
    private Integer requiredDoses;
    private String groupName;

    public Vaccine(){}
}
