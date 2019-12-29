package mw.library.catalogue.infrastructure;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

//@Profile("remote")
@Configuration
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
public class CatalogueDBConfiguration {
    //@Profile("remote")
    public @Bean
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://10.22.33.78:27017");
    }

    //@Profile("remote")
    public @Bean
    MongoDbFactory mongoDbFactory(@Autowired MongoClient client) {
        return new SimpleMongoClientDbFactory( client, "mw-library-database");
    }
}
