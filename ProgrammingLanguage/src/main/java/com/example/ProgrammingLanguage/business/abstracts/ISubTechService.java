package com.example.ProgrammingLanguage.business.abstracts;

import com.example.ProgrammingLanguage.business.requests.CreateSubTechRequest;
import com.example.ProgrammingLanguage.business.requests.UpdateSubTechRequest;
import com.example.ProgrammingLanguage.business.responses.GetAllSubTechResponse;
import com.example.ProgrammingLanguage.business.responses.GetByIdSubTechResponse;

import java.util.List;

public interface ISubTechService {
    List<GetAllSubTechResponse> getAll();
    void create(CreateSubTechRequest request);
    void update(UpdateSubTechRequest request);
    void delete(int id);
    GetByIdSubTechResponse getById(int id);
}
