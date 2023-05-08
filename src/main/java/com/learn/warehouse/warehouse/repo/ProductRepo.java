package com.learn.warehouse.warehouse.repo;

import com.learn.warehouse.warehouse.entity.Product;
import com.learn.warehouse.warehouse.entity.ProductType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> {
    List<Product> getProductsByType(ProductType type, Pageable pageable);
}
