package com.example.ProgrammingLanguage.webApi.Controllers;

import com.example.ProgrammingLanguage.business.abstracts.ISubTechService;
import com.example.ProgrammingLanguage.business.requests.CreateSubTechRequest;
import com.example.ProgrammingLanguage.business.requests.UpdateSubTechRequest;
import com.example.ProgrammingLanguage.business.responses.GetAllSubTechResponse;
import com.example.ProgrammingLanguage.business.responses.GetByIdSubTechResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subteches")
@AllArgsConstructor
public class SubtechesController {
    private ISubTechService _service;
    @GetMapping
    public List<GetAllSubTechResponse> getAll(){
        return this._service.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdSubTechResponse getById(@PathVariable int id){
        return this._service.getById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody CreateSubTechRequest createRequest){
        this._service.create(createRequest);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateSubTechRequest request){
        this._service.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this._service.delete(id);
    }
}
