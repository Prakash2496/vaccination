package com.hangarww.vaccination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VaccinationMatchDto {
    private String zipCode;
    private String vaccineId;
    private String vaccinationCentreId;
}
