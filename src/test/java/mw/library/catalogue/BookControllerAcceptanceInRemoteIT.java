package mw.library.catalogue;


import mw.library.catalogue.remote.LibraryManagementRemoteTestApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LibraryManagementRemoteTestApp.class)
@AutoConfigureMockMvc
class BookControllerAcceptanceInRemoteIT extends BookControllerAcceptanceTest {
    @Autowired
    private CatalogueFacade facade;

    @Override
    protected CatalogueFacade getFacade() {
        return facade;
    }

    @DisplayName("Positive test acceptance - add book to catalogue - remote database instance")
    @Test
    void acceptanceTestInRemoteDB() throws Exception {
        acceptance();
    }
}
