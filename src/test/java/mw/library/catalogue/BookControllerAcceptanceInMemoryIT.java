package mw.library.catalogue;


import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import mw.library.catalogue.inmemory.LibraryManagementInMemoryTestApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = LibraryManagementInMemoryTestApp.class)
@AutoConfigureMockMvc
@ComponentScan({"mw.library.catalogue.infrastructure"})
class BookControllerAcceptanceInMemoryIT extends BookControllerAcceptanceTest {

    CatalogueFacade facade = CatalogueConfigurationInMemory.catalogueFacade();

    @Override
    protected CatalogueFacade getFacade() {
        return facade;
    }

    @DisplayName("Positive test acceptance - add book to catalogue - in memory database instance")
    @Test
    void acceptanceTestInMemory() throws Exception {
        acceptance();
    }
}
