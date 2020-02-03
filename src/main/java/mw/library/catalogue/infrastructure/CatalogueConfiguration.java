package mw.library.catalogue.infrastructure;

import mw.library.catalogue.CatalogueFacade;
import mw.library.catalogue.CatalogueRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
public class CatalogueConfiguration {
    @Bean
    CatalogueFacade catalogueFacade(CatalogueRepository repository) {
        return new CatalogueFacadeBean(repository);
    }

    @Bean
    CatalogueRepository catalogueRepository(CatalogueBookMongoRepository bookMongoRepository
            , CatalogueBookInstMongoRepository bookInstMongoRepository) {
        return new CatalogueDatabase(bookMongoRepository, bookInstMongoRepository);
    }
}
