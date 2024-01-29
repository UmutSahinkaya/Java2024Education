package com.JavaWithReact.Northwind.api.controllers;

import com.JavaWithReact.Northwind.business.abstracts.ProductService;
import com.JavaWithReact.Northwind.core.utilities.results.DataResult;
import com.JavaWithReact.Northwind.core.utilities.results.Result;
import com.JavaWithReact.Northwind.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService _service;

    @GetMapping
    public DataResult<List<Product>> getAll(){
        return this._service.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this._service.add(product);
    }
}
