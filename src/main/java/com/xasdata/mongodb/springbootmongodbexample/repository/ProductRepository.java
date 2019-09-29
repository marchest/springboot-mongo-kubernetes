package com.xasdata.mongodb.springbootmongodbexample.repository;

import com.xasdata.mongodb.springbootmongodbexample.document.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {
    @Query("{'name' :{$regex:?0} }")
    List<Product> findProductByName(@Param("name") String name);
}
