package com.JavaWithReact.Northwind.business.abstracts;

import com.JavaWithReact.Northwind.dataAccess.abstracts.ProductDao;
import com.JavaWithReact.Northwind.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
}
