package mw.library.catalogue;

import mw.library.catalogue.infrastructure.CatalogueFacadeBean;
import mw.library.catalogue.standalone.LibraryManagementStandaloneApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;


@SpringBootTest(classes = LibraryManagementStandaloneApp.class)
@AutoConfigureMockMvc
@ComponentScan({"mw.library.catalogue.infrastructure"})
class BookControllerAcceptanceStandaloneIT extends BookControllerAcceptanceTest {

    @Autowired
    private CatalogueFacadeBean facade;

    @Override
    protected CatalogueFacadeBean getFacade() {
        return facade;
    }

    @DisplayName("Positive test acceptance - add book to catalogue - standalone database instance")
    @Test
    void acceptanceTestInStandaloneDB()
            throws Exception {
        acceptance();
    }
}