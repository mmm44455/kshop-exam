package com.vti.kshop_exam.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryDto {
    private Long id;
    private String name;
    private Long price;
    private String statusDamaged;
    private String repairStatus;
    @JsonProperty("licensePlate")
    private String carPkLicensePlate;
    @JsonProperty("repairDate")
    private LocalDate carPkRepairDate;
}
