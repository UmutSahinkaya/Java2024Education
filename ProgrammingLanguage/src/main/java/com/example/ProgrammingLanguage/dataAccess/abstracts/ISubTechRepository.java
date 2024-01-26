package com.example.ProgrammingLanguage.dataAccess.abstracts;

import com.example.ProgrammingLanguage.entities.concretes.SubTech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubTechRepository extends JpaRepository<SubTech,Integer> {
}
