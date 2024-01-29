package com.JavaWithReact.Northwind.business.concretes;

import com.JavaWithReact.Northwind.business.abstracts.ProductService;
import com.JavaWithReact.Northwind.core.utilities.results.DataResult;
import com.JavaWithReact.Northwind.core.utilities.results.Result;
import com.JavaWithReact.Northwind.core.utilities.results.SuccessDataResult;
import com.JavaWithReact.Northwind.core.utilities.results.SuccessResult;
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
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this._repository.findAll(),"Data listelendi.");
    }

    @Override
    public Result add(Product product) {
        this._repository.save(product);
        return new SuccessResult("Ürün eklendi.");
    }
}
