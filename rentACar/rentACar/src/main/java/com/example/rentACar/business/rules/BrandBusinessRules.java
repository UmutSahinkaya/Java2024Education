package com.example.rentACar.business.rules;

import com.example.rentACar.Core.utilities.exceptions.BusinessException;
import com.example.rentACar.dataAccess.abstracts.IBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private IBrandRepository _brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this._brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists");
        }
    }
}
