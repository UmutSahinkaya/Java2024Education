package com.example.rentACar.dataAccess.abstracts;

import com.example.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name); //spring jpa keywords
}
