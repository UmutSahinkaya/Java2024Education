package com.example.rentACar.business.concretes;

import com.example.rentACar.Core.utilities.mappers.ModelMapperService;
import com.example.rentACar.business.abstracts.IModelService;
import com.example.rentACar.business.requests.CreateModelRequest;
import com.example.rentACar.business.responses.GetAllModelsResponse;
import com.example.rentACar.dataAccess.abstracts.IModelRepository;
import com.example.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {
    private IModelRepository _modelRepository;
    private ModelMapperService _modelMapper;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models=_modelRepository.findAll();

        List<GetAllModelsResponse> response;
        response=models.stream().map(model -> this._modelMapper.forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=this._modelMapper.forRequest().map(createModelRequest,Model.class);
        this._modelRepository.save(model);
    }
}
