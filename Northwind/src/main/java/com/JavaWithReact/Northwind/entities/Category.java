package com.JavaWithReact.Northwind.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "categories")
    private List<Product> products;
}
