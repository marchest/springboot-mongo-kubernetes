package com.xasdata.mongodb.springbootmongodbexample.repository;

import com.xasdata.mongodb.springbootmongodbexample.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
