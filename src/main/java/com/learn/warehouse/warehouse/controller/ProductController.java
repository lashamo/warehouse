package com.learn.warehouse.warehouse.controller;

import com.learn.warehouse.warehouse.service.ProductService;
import com.learn.warehouse.warehouse.service.dto.AddProductRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody AddProductRequest product) {
        productService.addProduct(product);
    }

    @PutMapping("/increase-product-quantity")
    public void increaseQuantity(@RequestParam Long id, @RequestParam int quantity) {
        productService.increaseQuantity(id, quantity);
    }

    @PutMapping("/decrease-product-quantity")
    public  void  decreaseQuantity(@RequestParam Long id, @RequestParam int quantity){
        productService.decreaseQuantity(id, quantity);
    }
}