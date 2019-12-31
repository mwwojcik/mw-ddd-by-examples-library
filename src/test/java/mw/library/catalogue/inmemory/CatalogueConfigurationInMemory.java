package mw.library.catalogue.inmemory;

import mw.library.catalogue.CatalogueFacade;
import org.springframework.context.annotation.Bean;


public class CatalogueConfigurationInMemory {

    @Bean
    public static CatalogueFacade catalogueFacade() {
        return new CatalogueFacade(new InMemoryCatalogueDatabase());
    }
}
