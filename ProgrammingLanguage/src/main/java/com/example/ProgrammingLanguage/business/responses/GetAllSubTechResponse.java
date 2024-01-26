package com.example.ProgrammingLanguage.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubTechResponse {
    private int id;
    private String name;
    private String programmingLanguageName;
}
