package com.example.rentACar.business.concretes;

import com.example.rentACar.Core.utilities.mappers.ModelMapperService;
import com.example.rentACar.business.abstracts.IBrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import com.example.rentACar.business.rules.BrandBusinessRules;
import com.example.rentACar.dataAccess.abstracts.IBrandRepository;
import com.example.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements IBrandService {
    private IBrandRepository _brandRepository;
    private ModelMapperService _modelMapperService;
    private BrandBusinessRules _businessRules;
    @Override
    public List<GetAllBrandsResponse> getAll(){
        List<Brand> brands=_brandRepository.findAll();
       //ModelMapper kullanmadan önce
        /* List<GetAllBrandsResponse> brandsResponse=new ArrayList<GetAllBrandsResponse>();
        for (Brand brand:brands){
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }*/

        List<GetAllBrandsResponse> brandsResponse;
        brandsResponse=brands.stream()
                .map(brand ->this._modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        //iş kuralları
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this._brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response;
        response = this._modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        // Brand brand=new Brand();
        // brand.setName(createBrandRequest.getName());
        this._businessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand = this._modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this._brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this._modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this._brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this._brandRepository.deleteById(id);
    }

}
