package mw.library.catalogue.inmemory;

import mw.library.catalogue.infrastructure.CatalogueFacadeBean;
import org.springframework.context.annotation.Bean;


public class CatalogueConfigurationInMemory {

    @Bean
    public static CatalogueFacadeBean catalogueFacade() {
        return new CatalogueFacadeBean(new InMemoryCatalogueDatabase());
    }
}
