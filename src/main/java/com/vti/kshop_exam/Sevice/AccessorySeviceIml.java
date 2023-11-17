package com.vti.kshop_exam.Sevice;

import com.vti.kshop_exam.Dto.AccessoryDto;
import com.vti.kshop_exam.Enity.Accessory;
import com.vti.kshop_exam.Enity.Car;
import com.vti.kshop_exam.Form.AccessorryCreateForm;
import com.vti.kshop_exam.Form.AccessorryUpdateForm;
import com.vti.kshop_exam.Reponsity.AccessoryRepon;
import com.vti.kshop_exam.Reponsity.CarRepon;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccessorySeviceIml implements AccessorySevice {

    private final AccessoryRepon accessoryRepon;
    private final CarRepon carRepon;
    private final ModelMapper modelMapper;

    @Override
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryRepon.findAll(pageable).map(accessory ->
                modelMapper.map(accessory,AccessoryDto.class));
    }

    @Override
    public AccessoryDto create(AccessorryCreateForm form) {
        var acc = modelMapper.map(form, Accessory.class);
        var pk = modelMapper.map(form, Car.PrimaryKey.class);
        var car = carRepon.findById(pk).get();
        acc.setCar(car);
        var save = accessoryRepon.save(acc);
        return modelMapper.map(save,AccessoryDto.class);
    }

    @Override
    public AccessoryDto Update(Long id ,AccessorryUpdateForm form) {
        var acc = accessoryRepon.findById(id).get();
        modelMapper.map(form,acc);
        var save = accessoryRepon.save(acc);
        return modelMapper.map(save,AccessoryDto.class);
    }

    @Override
    public void deleteById(Long id) {
            accessoryRepon.deleteById(id);
    }
}
