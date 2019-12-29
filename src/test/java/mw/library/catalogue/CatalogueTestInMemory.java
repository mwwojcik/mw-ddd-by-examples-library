package mw.library.catalogue;


import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import org.assertj.core.api.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;



class CatalogueTestInMemory {

    CatalogueFacade facade = CatalogueConfigurationInMemory.catalogueFacade();

    @DisplayName("In memory test")
    @Test
    void test()
            throws Exception {
        // given
        // when 
        // then

        Fail.fail("Write your test");

    }
}
