package com.example.crudapi.controllers;

import com.example.crudapi.entities.ProductEntity;
import com.example.crudapi.entities.SpringUsersEntity;
import com.example.crudapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> findAllProduct() {
        List<ProductEntity> listUser = productService.findAll();
        if(listUser.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity u) {
        productService.saveProduct(u);
        return new ResponseEntity<ProductEntity>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductEntity> getUser(@PathVariable(value = "id") Integer id) {
        ProductEntity product = productService.findById(id);
        return new ResponseEntity<ProductEntity>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductEntity> sellProduct(
            @PathVariable(value="id") Integer id,
            @RequestBody Integer quantity) {
        ProductEntity oldProduct = productService.findById(id);
        if(oldProduct.getQuantity() > quantity) {
            oldProduct.setQuantity(oldProduct.getQuantity() - quantity);
            productService.saveProduct(oldProduct);
            return new ResponseEntity<ProductEntity>(oldProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
