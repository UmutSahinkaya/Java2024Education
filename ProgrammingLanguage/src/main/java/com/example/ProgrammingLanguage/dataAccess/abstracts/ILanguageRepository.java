package com.example.ProgrammingLanguage.dataAccess.abstracts;

import com.example.ProgrammingLanguage.entities.concretes.Language;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language,Integer>  {
}
