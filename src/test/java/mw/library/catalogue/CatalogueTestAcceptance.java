package mw.library.catalogue;

import mw.library.LibraryManagementApp;
import mw.library.catalogue.CatalogueFacade;
import mw.library.catalogue.infrastructure.CatalogueConfiguration;
import mw.library.catalogue.infrastructure.CatalogueDBConfiguration;
import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest(classes = LibraryManagementApp.class)
@ContextConfiguration(classes = {CatalogueConfiguration.class})
class CatalogueTestAcceptance {

    @Autowired
    private CatalogueFacade facade;

    @DisplayName("Positive test acceptance - rental dvd movie")
    @Test
    void positiveRental()
            throws Exception {
        System.out.println("test");
        // given inventory with three films added
        // "Clerks" (type=old), "Frozen" (type="regular"), "Toy Story 4" (type=new)

        // when 'I go /films'
        // then 'I can see all 3 films'

        // when 'I go /points'
        // then 'I can see no points'

        //when 'I post /price with all movies for standard period 2 days'
        //then 'I can see: Clerks (price=10),Frozen(price=20), Toy Story 4 (price=30), Total=60 '

        //when 'I go /reservation'
        //then 'I can see empty list'

        //when 'I post /reservation with all movies for standard period 2 days'
        //then 'I have reserved all movies'

        //when 'I go /reservation'
        //then 'I can see three position list'

        //when 'I go /rental'
        //then 'I can see empty list'

        //when 'I post /rental with three films for standard 2 days'
        //then 'I rent three films'

        //when 'I go /rental'
        //then 'I can see three position list'

        //when 'I go /points'
        //then 'I can see 3 points'

        //when 'I go /review'
        //then 'I can see empty list'

        //when 'I post /review with my comment for Clerks'
        //then 'My review was added'

        //when 'I go /review'
        //then 'I can see list with one position'

        //when 'I go /points'
        //then 'I can see 8 points'
    }
}