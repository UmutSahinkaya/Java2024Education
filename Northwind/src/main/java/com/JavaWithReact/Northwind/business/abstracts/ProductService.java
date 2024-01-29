package com.JavaWithReact.Northwind.business.abstracts;

import com.JavaWithReact.Northwind.core.utilities.results.DataResult;
import com.JavaWithReact.Northwind.core.utilities.results.Result;
import com.JavaWithReact.Northwind.dataAccess.abstracts.ProductDao;
import com.JavaWithReact.Northwind.entities.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
}
