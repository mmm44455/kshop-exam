package com.vti.kshop_exam.Sevice;

import com.vti.kshop_exam.Dto.CarDto;
import com.vti.kshop_exam.Enity.Car;
import com.vti.kshop_exam.Form.CarCreateForm;
import com.vti.kshop_exam.Form.CarUpdateForm;
import com.vti.kshop_exam.Reponsity.CarRepon;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarSeviceIml implements Carsevice{

    private final CarRepon carRepon;
    private final ModelMapper modelMapper;

    @Override
    public Page<CarDto> findAll(Pageable pageable) {
        return carRepon.findAll(pageable).map(car ->
                modelMapper.map(car, CarDto.class));
    }

    @Override
    public CarDto create(CarCreateForm form) {
        var create = modelMapper.map(form, Car.class);
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        create.setPk(pk);
        var save = carRepon.save(create);
        return modelMapper.map(save, CarDto.class);
    }

    @Override
    public CarDto update(CarUpdateForm form) {
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        var car = carRepon.findById(pk).get();
        modelMapper.map(form,car);
        var save = carRepon.save(car);
        return modelMapper.map(save, CarDto.class);
    }

    @Override
    public void deleteById(Car.PrimaryKey pk) {
            carRepon.deleteById(pk);
    }

}
