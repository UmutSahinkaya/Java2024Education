package com.example.ProgrammingLanguage.business.abstracts;

import com.example.ProgrammingLanguage.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguage.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguage.business.responses.GetAllLanguageResponse;
import com.example.ProgrammingLanguage.business.responses.GetByIdLanguageResponse;
import com.example.ProgrammingLanguage.entities.concretes.Language;

import java.util.List;

public interface ILanguageService {
    List<GetAllLanguageResponse> getAll();
    void create(CreateLanguageRequest request);
    void update(UpdateLanguageRequest request);
    void delete(int id);
    GetByIdLanguageResponse getById(int id);
}
