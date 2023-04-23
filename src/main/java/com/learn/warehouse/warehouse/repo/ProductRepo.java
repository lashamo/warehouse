package com.learn.warehouse.warehouse.repo;
import com.learn.warehouse.warehouse.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends  CrudRepository<Product,Long>{
}
