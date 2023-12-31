package com.vti.kshop_exam.Form;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
public class AccessorryCreateForm {
    @NotBlank
    @Length(max = 255)
    private String name;

    @NotNull
    @PositiveOrZero
    private Long price;

    @NotBlank
    @Length(max = 255)
    private String statusDamaged;

    @NotBlank
    @Length(max = 255)
    private String repairStatus;

    @NotBlank
    @Length(max = 255)
    private String licensePlate;

    @NotNull
    @PastOrPresent
    private LocalDate repairDate;
}
