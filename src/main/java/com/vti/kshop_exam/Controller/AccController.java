package com.vti.kshop_exam.Controller;

import com.vti.kshop_exam.Dto.AccessoryDto;
import com.vti.kshop_exam.Form.AccessorryCreateForm;
import com.vti.kshop_exam.Form.AccessorryUpdateForm;
import com.vti.kshop_exam.Sevice.AccessorySevice;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Validated
@CrossOrigin("*")
public class AccController {
    private final AccessorySevice accessorySevice;

    @PostMapping("/api/v2/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create(@RequestBody @Valid AccessorryCreateForm form){
        return accessorySevice.create(form);
    }

    @PutMapping("/api/v2/accessories/{id}")
    public AccessoryDto Update(@PathVariable("id") Long id ,@RequestBody @Valid AccessorryUpdateForm form){
        return accessorySevice.Update(id,form);
    }

    @GetMapping("/api/v2/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable){
        return accessorySevice.findAll(pageable);
    }

    @DeleteMapping("/api/v2/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
       accessorySevice.deleteById(id);
    }
}
