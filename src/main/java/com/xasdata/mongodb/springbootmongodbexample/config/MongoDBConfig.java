package com.xasdata.mongodb.springbootmongodbexample.config;


import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.xasdata.mongodb.springbootmongodbexample.repository")
public class MongoDBConfig {

    @Bean
    public MongoClient mongoClient(){

        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(mongoClient(),"trendfitscraperdb");

    }

}
