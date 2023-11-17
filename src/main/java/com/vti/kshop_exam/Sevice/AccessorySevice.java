package com.vti.kshop_exam.Sevice;

import com.vti.kshop_exam.Dto.AccessoryDto;
import com.vti.kshop_exam.Form.AccessorryCreateForm;
import com.vti.kshop_exam.Form.AccessorryUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessorySevice {
    Page<AccessoryDto> findAll(Pageable pageable);
    AccessoryDto create(AccessorryCreateForm form);
    AccessoryDto Update(Long id ,AccessorryUpdateForm form);

    void deleteById(Long id);
}
