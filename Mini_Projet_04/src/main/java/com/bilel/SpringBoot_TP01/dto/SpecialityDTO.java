package com.bilel.SpringBoot_TP01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SpecialityDTO {
    private Long specialityId;
    private String specialityName;
}
