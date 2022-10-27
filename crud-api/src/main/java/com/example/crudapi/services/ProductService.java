package com.example.crudapi.services;

import com.example.crudapi.entities.ProductEntity;


import java.util.List;

public interface ProductService {
    public void saveProduct(ProductEntity u);
    public ProductEntity findById(Integer id);
    public List<ProductEntity> findAll();
}
