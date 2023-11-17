package com.vti.kshop_exam.Form;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class CarCreateForm {
    @NotBlank(message = "{car.licensePlate.NotBlank.message}")
    @Length(max = 50,message = "{car.licensePlate.Length.message}")
    private  String licensePlate;

    @NotNull
    @PastOrPresent
    private LocalDate repairDate;

    @NotBlank
    @Length(max = 50)
    private String customerName;

    @NotBlank
    @Length(max = 50)
    private String catalog;

    @NotBlank
    @Length(max = 50)
    private String carMaker;

}
