package com.JavaWithReact.Northwind.business.abstracts;

import com.JavaWithReact.Northwind.core.utilities.results.DataResult;
import com.JavaWithReact.Northwind.core.utilities.results.Result;
import com.JavaWithReact.Northwind.dataAccess.abstracts.ProductDao;
import com.JavaWithReact.Northwind.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
//    Result update(Product product);
//    Result delete(Product product);
    DataResult<Product> findByProductName(String productName);
    DataResult<Product> findByProductNameAndCategoryId(String productName,int categoryId);
    DataResult<List<Product>> findByProductNameOrCategoryId(String productName,int categoryId);
    DataResult<List<Product>> findByCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> findByProductNameContains(String productName);
    DataResult<List<Product>> findByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
}
