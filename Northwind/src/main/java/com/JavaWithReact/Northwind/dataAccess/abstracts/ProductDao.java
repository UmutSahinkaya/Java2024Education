package com.JavaWithReact.Northwind.dataAccess.abstracts;

import com.JavaWithReact.Northwind.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
