package com.example.ProgrammingLanguage.business.concretes;

import com.example.ProgrammingLanguage.business.abstracts.ISubTechService;
import com.example.ProgrammingLanguage.business.requests.CreateSubTechRequest;
import com.example.ProgrammingLanguage.business.requests.UpdateSubTechRequest;
import com.example.ProgrammingLanguage.business.responses.GetAllSubTechResponse;
import com.example.ProgrammingLanguage.business.responses.GetByIdSubTechResponse;
import com.example.ProgrammingLanguage.core.utilities.mappers.ModelMapperService;
import com.example.ProgrammingLanguage.dataAccess.abstracts.ISubTechRepository;
import com.example.ProgrammingLanguage.entities.concretes.SubTech;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubTechManager implements ISubTechService {
    private ModelMapperService _modelMapperService;
    private ISubTechRepository _repository;

    @Override
    public List<GetAllSubTechResponse> getAll() {
        List<SubTech> subTechs=_repository.findAll();
        List<GetAllSubTechResponse> responses;
        responses=subTechs.stream()
                .map(subtech ->
                        this._modelMapperService
                                .forResponse()
                                .map(subtech, GetAllSubTechResponse.class))
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public void create(CreateSubTechRequest request) {
        SubTech subtech=this._modelMapperService.forRequest().map(request,SubTech.class);
        this._repository.save(subtech);
    }

    @Override
    public void update(UpdateSubTechRequest request) {
        SubTech subtech=this._modelMapperService.forRequest().map(request,SubTech.class);
        this._repository.save(subtech);
    }

    @Override
    public void delete(int id) {
        this._repository.deleteById(id);
    }

    @Override
    public GetByIdSubTechResponse getById(int id) {
        SubTech subTech =this._repository.findById(id).orElseThrow();
        GetByIdSubTechResponse response;
        response=this._modelMapperService.forResponse().map(subTech,GetByIdSubTechResponse.class);
        return response;
    }
}
