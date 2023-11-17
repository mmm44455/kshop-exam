package com.vti.kshop_exam.Controller;

import com.vti.kshop_exam.Dto.CarDto;
import com.vti.kshop_exam.Enity.Car;
import com.vti.kshop_exam.Form.CarCreateForm;
import com.vti.kshop_exam.Form.CarUpdateForm;
import com.vti.kshop_exam.Sevice.Carsevice;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@AllArgsConstructor
@RestController
@CrossOrigin("*")
public class CarController {
    private final Carsevice carsevice;

    @GetMapping("api/v2/cars")
    public Page<CarDto> findAll(Pageable pageable){
        return carsevice.findAll(pageable);
    }
    @PostMapping("/api/v2/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto create(@RequestBody @Valid CarCreateForm form){
        return carsevice.create(form);
    }

    @PutMapping("/api/v2/cars")
    public CarDto update(@RequestBody @Valid CarUpdateForm form){
        return carsevice.update(form);
    }

    @DeleteMapping("/api/v2/cars")
    public void deleteById( Car.PrimaryKey pk){
        carsevice.deleteById(pk);
    }
}
