package com.learn.warehouse.warehouse.service;

import com.learn.warehouse.warehouse.entity.Product;
import com.learn.warehouse.warehouse.entity.ProductType;
import com.learn.warehouse.warehouse.repo.ProductRepo;
import com.learn.warehouse.warehouse.service.dto.AddProductRequest;
import com.learn.warehouse.warehouse.service.exception.WarehouseException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public void addProduct(AddProductRequest addProductRequest) {
        productRepo.save(mapProductToAddRequest(addProductRequest));
    }

    @Override
    public void increaseQuantity(Long id, int quantity) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setQuantity(product.getQuantity() + quantity);
            productRepo.save(product);
        } else {
            throw new WarehouseException(String.format("Product[%d] could not found", id));
        }
    }

    @Override
    public void decreaseQuantity(Long id, int quantity) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (product.getQuantity() < quantity) {
                throw new WarehouseException(String.format("The quantity[%d] in warehouse is less then requested[%d]", product.getQuantity(), quantity));
            } else {
                product.setQuantity(product.getQuantity() - quantity);
                productRepo.save(product);
            }
        } else {
            throw new WarehouseException(String.format("Product[%d] could not found ", id));
        }
    }

    private Product mapProductToAddRequest(AddProductRequest addProductRequest) {
        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setDescription(addProductRequest.getDescription());
        try {
            product.setType(ProductType.valueOf(addProductRequest.getType()));
        } catch (IllegalArgumentException ex) {
            throw new WarehouseException(String.format("Product type[%s] is not available", addProductRequest.getType()));
        }
        product.setPrice(addProductRequest.getPrice());
        product.setQuantity(addProductRequest.getQuantity());
        return product;
    }
}
