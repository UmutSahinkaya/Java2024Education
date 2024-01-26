package com.example.rentACar.webApi.Controllers;

import com.example.rentACar.business.abstracts.IBrandService;
import com.example.rentACar.business.requests.CreateBrandRequest;
import com.example.rentACar.business.requests.UpdateBrandRequest;
import com.example.rentACar.business.responses.GetAllBrandsResponse;
import com.example.rentACar.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController{
    private IBrandService _service;
    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return _service.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return _service.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest){
        this._service.add(createBrandRequest);
    }

    @PutMapping
    public void Update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this._service.update(updateBrandRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this._service.delete(id);
    }

}
