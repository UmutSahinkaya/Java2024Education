package com.example.rentACar.dataAccess.abstracts;

import com.example.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModelRepository extends JpaRepository<Model,Integer> {
}
