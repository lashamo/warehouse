package com.learn.warehouse.warehouse.service;

import com.learn.warehouse.warehouse.service.dto.AddProductRequest;
import com.learn.warehouse.warehouse.service.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void addProduct(AddProductRequest addProductRequest);
    void increaseQuantity(Long id, int quantity);
    void decreaseQuantity(Long id, int quantity);
    List<ProductResponse> getProductsByType(String type);
}
