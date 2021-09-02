package com.hangarww.vaccination.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VaccinationResponseDto {
    private String message;
    private String aadharId;
    private String person;
    private Integer dose;
    private String vaccine;
    private String vaccinationCentre;
    private String vaccinationLocation;
    private boolean statusOK;

}
