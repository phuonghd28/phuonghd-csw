package com.example.crudapi.services;

import com.example.crudapi.entities.ProductEntity;
import com.example.crudapi.entities.SpringUsersEntity;
import com.example.crudapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public void saveProduct(ProductEntity u) {
        productRepository.save(u);
    }

    @Override
    public ProductEntity findById(Integer id) {
        Optional<ProductEntity> products = productRepository.findById(id);
        ProductEntity product = products.get();
        return product;
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}
