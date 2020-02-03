package mw.library.catalogue;


import mw.library.catalogue.infrastructure.CatalogueFacadeBean;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;

/*@SpringBootTest(classes = LibraryManagementRemoteTestApp.class)
@AutoConfigureMockMvc
@ComponentScan({"mw.library.catalogue.infrastructure"})*/
class BookControllerAcceptanceInRemoteIT extends BookControllerAcceptanceTest {
    @Autowired
    private CatalogueFacadeBean facade;

    @Override
    protected CatalogueFacadeBean getFacade() {
        return facade;
    }

    @DisplayName("Positive test acceptance - add book to catalogue - remote database instance")
    //@Test
    void acceptanceTestInRemoteDB() throws Exception {
        acceptance();
    }
}
