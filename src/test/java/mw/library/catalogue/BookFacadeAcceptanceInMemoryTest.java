package mw.library.catalogue;


import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import mw.library.catalogue.inmemory.LibraryManagementInMemoryTestApp;
import mw.library.catalogue.standalone.LibraryManagementStandaloneApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

class BookFacadeAcceptanceInMemoryTest extends BookFacadeAcceptanceTest {

    CatalogueFacade facade = CatalogueConfigurationInMemory.catalogueFacade();

    @Override
    protected CatalogueFacade getFacade() {
        return facade;
    }

    @DisplayName("Positive test acceptance - add book to catalogue - in memory database instance")
    @Test
    void acceptanceTestInMemory(){
        acceptance();
    }

}
