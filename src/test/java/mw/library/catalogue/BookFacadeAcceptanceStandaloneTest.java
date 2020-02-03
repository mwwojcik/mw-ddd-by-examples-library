package mw.library.catalogue;


import mw.library.catalogue.infrastructure.CatalogueFacadeBean;
import mw.library.catalogue.standalone.LibraryManagementStandaloneApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LibraryManagementStandaloneApp.class)
@AutoConfigureMockMvc
@ComponentScan({"mw.library.catalogue.infrastructure"})
class BookFacadeAcceptanceStandaloneTest extends BookFacadeAcceptanceTest {

    @Autowired
    CatalogueFacadeBean facade;// = CatalogueConfigurationInMemory.catalogueFacade();

    @Override
    protected CatalogueFacadeBean getFacade() {
        return facade;
    }

    @DisplayName("Standalone test")
    @Test
    void acceptanceTestStandalone() throws Exception {
        acceptance();
    }

}
