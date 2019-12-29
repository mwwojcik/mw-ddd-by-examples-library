package mw.library.catalogue.inmemory;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class
        , MongoDataAutoConfiguration.class
        , EmbeddedMongoAutoConfiguration.class})
public class LibraryManagementInMemoryTestApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(LibraryManagementInMemoryTestApp.class)
                .web(WebApplicationType.SERVLET).run(args);
    }
}