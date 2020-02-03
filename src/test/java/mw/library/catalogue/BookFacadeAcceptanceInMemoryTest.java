package mw.library.catalogue;


import mw.library.catalogue.infrastructure.CatalogueFacadeBean;
import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BookFacadeAcceptanceInMemoryTest extends BookFacadeAcceptanceTest {

    CatalogueFacadeBean facade = CatalogueConfigurationInMemory.catalogueFacade();

    @Override
    protected CatalogueFacadeBean getFacade() {
        return facade;
    }

    @DisplayName("Positive test acceptance - add book to catalogue - in memory database instance")
    @Test
    void acceptanceTestInMemory(){
        acceptance();
    }

}
