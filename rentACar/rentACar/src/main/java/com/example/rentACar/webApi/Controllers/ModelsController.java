package com.example.rentACar.webApi.Controllers;

import com.example.rentACar.business.abstracts.IModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private IModelService _service;

    @GetMapping
    public List<GetAllModelsResponse> getAll(){
        return _service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest){
        this._service.add(createModelRequest);
    }
}
