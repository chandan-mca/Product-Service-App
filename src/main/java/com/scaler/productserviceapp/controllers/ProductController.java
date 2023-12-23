package com.scaler.productserviceapp.controllers;

import com.scaler.productserviceapp.models.Product;
import com.scaler.productserviceapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

}
