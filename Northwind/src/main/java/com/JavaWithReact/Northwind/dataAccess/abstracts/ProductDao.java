package com.JavaWithReact.Northwind.dataAccess.abstracts;

import com.JavaWithReact.Northwind.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product findByProductName(String productName);
    Product findByProductNameAndCategoryId(String productName,int categoryId);
    List<Product> findByProductNameOrCategoryId(String productName,int categoryId);
    List<Product> findByCategoryIdIn(List<Integer> categories);
    List<Product> findByProductNameContains(String productName);
    List<Product> findByProductNameStartsWith(String productName);
    @Query("From Product where productName=:productName and categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);//JPQL
}
