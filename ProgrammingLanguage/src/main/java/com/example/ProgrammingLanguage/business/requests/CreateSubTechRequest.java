package com.example.ProgrammingLanguage.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubTechRequest {
    @NotNull
    @NotBlank
    @Size(min = 1, max = 40)
    private String name;

    @NotNull
    @NotBlank
    private int languageId;
}
