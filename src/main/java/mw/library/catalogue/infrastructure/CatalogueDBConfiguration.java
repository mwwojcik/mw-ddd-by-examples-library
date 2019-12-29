package mw.library.catalogue.infrastructure;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class
        , MongoDataAutoConfiguration.class})
public class CatalogueDBConfiguration {
    public @Bean
        //MongoAutoConfiguration
    MongoClient mongoClient() {
        return MongoClients.create("mongodb://10.22.33.78:27017");
    }

    public @Bean
        //MongoAutoConfiguration
    MongoDbFactory mongoDbFactory(@Autowired MongoClient client) {
        return new SimpleMongoClientDbFactory(client, "mw-library-database");
    }

    @Bean
    //MongoDataAutoConfiguration
    public MongoTemplate mongoTemplate(MongoDbFactory factory) throws Exception {
        return new MongoTemplate(factory);
    }
}
