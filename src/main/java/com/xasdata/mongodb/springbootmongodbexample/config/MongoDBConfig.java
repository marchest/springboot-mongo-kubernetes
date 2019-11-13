package com.xasdata.mongodb.springbootmongodbexample.config;


import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.xasdata.mongodb.springbootmongodbexample.repository")
public class MongoDBConfig {
  @Value("${spring.profiles.active}")
  String profile;

    @Value("${mongo.db.host}")
    private String host;
    @Profile("dev")
    @Bean
    public MongoClient mongoClientDev(){

        return new MongoClient(host);
    }

    @Profile("test")
    @Bean
    public MongoClient mongoClientTest(){

        return new MongoClient(host);
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        MongoTemplate mongoTemplate=null;
        try {
            if (profile=="dev"){
                mongoTemplate= new MongoTemplate(mongoClientDev(),"trendfitscraperdb");
            }
            else
                mongoTemplate=new MongoTemplate(mongoClientTest(),"trendfitscraperdb");

        }catch (Exception e){
            System.out.println("Mongoya bağlanırken hata oluştu: "+e.getMessage());
        }
        return mongoTemplate;
    }


}
