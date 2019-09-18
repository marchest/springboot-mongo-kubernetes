package com.xasdata.mongodb.springbootmongodbexample.controller;

import com.xasdata.mongodb.springbootmongodbexample.document.Product;
import com.xasdata.mongodb.springbootmongodbexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class ProductController {

    @Autowired
    ProductRepository productRepository;



    @GetMapping(value = "/products",produces = "application/json")
    public @ResponseBody
    Product getProducts(){
        Optional<Product> byId = productRepository.findById("5d07df4a94674349883187d6");
        return byId.get();
    }


}
