package com.xasdata.mongodb.springbootmongodbexample.controller;

import com.xasdata.mongodb.springbootmongodbexample.document.Product;
import com.xasdata.mongodb.springbootmongodbexample.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class ProductController {

    @Autowired
    ProductRepository productRepository;



    private static final Logger logger= LogManager.getLogger(ProductController.class);

    @GetMapping(value = "/products",produces = "application/json")
    public @ResponseBody
    Product getProducts(){
        Optional<Product> byId = productRepository.findById("5d07df4a94674349883187d6");
        return byId.get();
    }

    @GetMapping(value = "/products/name",produces = "application/json")
    public @ResponseBody
    List<Product> getProductByName(@RequestParam(name = "name")String name){
        List<Product>byName= productRepository.findProductByName(name.toUpperCase());
        return  byName;
    }


    @PostMapping(value="/test")
    public String deneme( String body){

        logger.info("info log"+body);
        return body;
    }
}
