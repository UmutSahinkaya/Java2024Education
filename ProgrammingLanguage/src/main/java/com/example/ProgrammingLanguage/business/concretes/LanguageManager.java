package com.example.ProgrammingLanguage.business.concretes;

import com.example.ProgrammingLanguage.business.abstracts.ILanguageService;
import com.example.ProgrammingLanguage.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguage.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguage.business.responses.GetAllLanguageResponse;
import com.example.ProgrammingLanguage.business.responses.GetByIdLanguageResponse;
import com.example.ProgrammingLanguage.core.utilities.mappers.ModelMapperService;
import com.example.ProgrammingLanguage.dataAccess.abstracts.ILanguageRepository;
import com.example.ProgrammingLanguage.entities.concretes.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageManager implements ILanguageService {
    private ILanguageRepository _repository;
    private ModelMapperService _modelMapperService;
    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages=_repository.findAll();
        List<GetAllLanguageResponse> response;
        response=languages.stream()
                .map(language -> this._modelMapperService.forResponse().map(language,GetAllLanguageResponse.class)).collect(Collectors.toList());
        return response;
    }
    @Override
    public void create(CreateLanguageRequest request) {
        Language language=this._modelMapperService.forRequest().map(request,Language.class);
        this._repository.save(language);
    }
    @Override
    public void update(UpdateLanguageRequest request) {
        Language language=this._modelMapperService.forRequest().map(request,Language.class);
        _repository.save(language);
    }
    @Override
    public void delete(int id) {
        this._repository.deleteById(id);
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language language= this._repository.findById(id).orElseThrow();
        GetByIdLanguageResponse response;
        response=this._modelMapperService.forResponse().map(language,GetByIdLanguageResponse.class);
        return response;
    }
}
