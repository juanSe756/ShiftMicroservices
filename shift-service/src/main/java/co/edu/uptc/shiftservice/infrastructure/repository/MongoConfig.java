package co.edu.uptc.shiftservice.infrastructure.repository;

import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Bean
    public SimpleMongoClientDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(MongoClients.create("mongodb://mongo" +
                ":ibTLoGVUykDlJdRVlFiZQrjTZIAPVjkJ@roundhouse.proxy.rlwy.net:25440"), "ShiftsBD");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}