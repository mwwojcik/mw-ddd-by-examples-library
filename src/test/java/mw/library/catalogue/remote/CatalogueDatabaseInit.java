package mw.library.catalogue.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
class CatalogueDatabaseInit implements ApplicationRunner {
    @Autowired
    private MongoDbFactory factory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MongoOperations mongoOps = new MongoTemplate(factory);
        mongoOps.dropCollection("book");
        mongoOps.createCollection("book");
    }


}
