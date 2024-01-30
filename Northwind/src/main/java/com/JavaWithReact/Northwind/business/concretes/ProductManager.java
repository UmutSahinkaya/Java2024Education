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

//    @Override
//    public Result update(Product product) {
//        return new SuccessResult(this._repository.save(product),"Ürün güncellendi");
//    }

//    @Override
//    public Result delete(Product product) {
//        return null;
//    }

    @Override
    public DataResult<Product> findByProductName(String productName) {
        return new SuccessDataResult<Product>(this._repository.findByProductName(productName),"Ürün adına göre listelendi");
    }

    @Override
    public DataResult<Product> findByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this._repository.findByProductNameAndCategoryId(productName,categoryId),"Ürün adına ve kategorisine göre listelendi");
    }

    @Override
    public DataResult<List<Product>> findByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this._repository.findByProductNameOrCategoryId(productName,categoryId),"Ürün adına veya kategorisine göre listelendi");
    }

    @Override
    public DataResult<List<Product>> findByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this._repository.findByCategoryIdIn(categories),"Kategorilerine göre listelendi");
    }

    @Override
    public DataResult<List<Product>> findByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this._repository.findByProductNameContains(productName),"Ürünün adının bir kısmına göre veriler listelendi.");
    }

    @Override
    public DataResult<List<Product>> findByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this._repository.findByProductNameStartsWith(productName),"Ürünün adının baslangıcına göre veriler listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this._repository.getByNameAndCategory(productName,categoryId),"Ürünün adına veya kategorisine göre veriler listelendi.");
    }
}
