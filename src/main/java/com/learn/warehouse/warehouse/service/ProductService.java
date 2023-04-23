package com.learn.warehouse.warehouse.service;

import com.learn.warehouse.warehouse.service.dto.AddProductRequest;

public interface ProductService {
    void addProduct(AddProductRequest addProductRequest);

    void increaseQuantity(Long id, int quantity);
    void decreaseQuantity(Long id, int quantity);
}
