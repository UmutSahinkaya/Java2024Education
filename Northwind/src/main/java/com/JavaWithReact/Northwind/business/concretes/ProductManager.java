package com.JavaWithReact.Northwind.business.concretes;

import com.JavaWithReact.Northwind.business.abstracts.ProductService;
import com.JavaWithReact.Northwind.dataAccess.abstracts.ProductDao;
import com.JavaWithReact.Northwind.entities.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductDao _repository;
    @Override
    public List<Product> getAll() {
        return _repository.findAll();
    }
}
