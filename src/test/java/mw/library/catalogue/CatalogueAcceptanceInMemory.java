package mw.library.catalogue;


import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CatalogueAcceptanceInMemory {

    CatalogueFacade facade = CatalogueConfigurationInMemory.catalogueFacade();

    @DisplayName("In memory test")
    @Test
    void acceptanceTestInMemory()
            throws Exception {
        // given
        // when 
        // then

        Fail.fail("Write your test");

    }
}
