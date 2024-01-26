package com.example.ProgrammingLanguage.webApi.Controllers;

import com.example.ProgrammingLanguage.business.abstracts.ILanguageService;
import com.example.ProgrammingLanguage.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguage.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguage.business.responses.GetAllLanguageResponse;
import com.example.ProgrammingLanguage.business.responses.GetByIdLanguageResponse;
import com.example.ProgrammingLanguage.entities.concretes.Language;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {
    private ILanguageService _service;

    @GetMapping()
    public List<GetAllLanguageResponse> getAll(){
        return this._service.getAll();
    }

    @PostMapping("create")
    public void create(@RequestBody CreateLanguageRequest language){
        _service.create(language);
    }

    @GetMapping("/{id}")
    public GetByIdLanguageResponse getById(@PathVariable int id){
        return this._service.getById(id);
    }

    @PutMapping("update")
    public void update(@RequestBody UpdateLanguageRequest lang){
        _service.update(lang);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        _service.delete(id);
    }
}
