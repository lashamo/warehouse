package com.learn.warehouse.warehouse.repo;
import com.learn.warehouse.warehouse.entity.Product;
import com.learn.warehouse.warehouse.entity.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends  CrudRepository<Product,Long>{
    List<Product> getProductsByType(ProductType type);
}
