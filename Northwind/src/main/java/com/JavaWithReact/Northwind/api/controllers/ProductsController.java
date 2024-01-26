package com.JavaWithReact.Northwind.api.controllers;

import com.JavaWithReact.Northwind.business.abstracts.ProductService;
import com.JavaWithReact.Northwind.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService _service;

    @GetMapping
    public List<Product> getAll(){
        return _service.getAll();
    }
}
