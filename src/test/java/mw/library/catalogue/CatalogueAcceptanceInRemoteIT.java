package mw.library.catalogue;


import mw.library.LibraryManagementApp;
import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import mw.library.catalogue.remote.LibraryManagementRemoteTestApp;
import mw.library.catalogue.standalone.LibraryManagementStandaloneApp;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LibraryManagementRemoteTestApp.class)
class CatalogueAcceptanceInRemoteIT {

    CatalogueFacade facade = CatalogueConfigurationInMemory.catalogueFacade();

    @DisplayName("In remote test")
    @Test
    void acceptanceTestInRemoteDB()
            throws Exception {
        // given
        // when 
        // then

        Fail.fail("Write your test");

    }
}
