package com.vti.kshop_exam.Sevice;

import com.vti.kshop_exam.Dto.CarDto;
import com.vti.kshop_exam.Enity.Car;
import com.vti.kshop_exam.Form.CarCreateForm;
import com.vti.kshop_exam.Form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Carsevice{
    Page<CarDto> findAll(Pageable pageable);
    CarDto create(CarCreateForm form);

    CarDto update(CarUpdateForm form);

    void deleteById(Car.PrimaryKey pk);
}
