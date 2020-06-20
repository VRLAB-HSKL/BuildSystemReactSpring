package com.hskl.buildsystem.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

/**
 * This class setup the MongoDB configuration
 */
@Configuration
public class MongoDBConfiguration {

    //MongoDB-IP
    @Value("${buildsystem.mongo.db.url}")
    private String MONGO_DB_URL;

    //MongoDB-Database-Name
    @Value("${buildsystem.mongo.db.name}")
    private String MONGO_DB_NAME;

    /***
     * Setup a @MongoClient an bind it to a given URL
     * @return MongoClient
     */
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(MONGO_DB_URL);
    }

    /***
     * Gives the configured DB-Client to the @MongoTemplate an setup the database name.
     * The template is used to communicate with
     * MongoDB
     * @return @MongoTemplate
     * @throws IOException
     */
    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongoClient(), MONGO_DB_NAME);
    }
}
