package com.hskl.buildsystem.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
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
    private static final String MONGO_DB_URL = "mongodb://127.0.0.1:27017";

    //MongoDB-Database-Name
    private static final String MONGO_DB_NAME = "mydatabase";

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
        return new MongoTemplate(mongoClient(), "mydatabase");
    }
}
