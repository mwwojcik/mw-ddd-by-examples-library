package mw.library.catalogue.inmemory;

import mw.library.catalogue.CatalogueFacade;


public class CatalogueConfigurationInMemory {

    public static CatalogueFacade catalogueFacade() {
        return new CatalogueFacade(new InMemoryCatalogueDatabase());
    }
}
