package mw.library.catalogue;


import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BookFacadeAcceptanceInMemoryTest {

    CatalogueFacade facade = CatalogueConfigurationInMemory.catalogueFacade();

    @DisplayName("In memory test")
    @Test
    void acceptanceTestInMemory() throws Exception {

        // given inventory with two books added
        // "Domain-Driven Design" - Eric Evans, "Implementing Domain Driven Desing" - Vaughn Vernon
        facade.saveNew(new Book(BooksFixture.DDD_ISBN_STR, "Eric Evans", "Domain-Driven Design"));
        facade.saveNew(new Book(BooksFixture.DDD_ISBN_STR_01, "Vaughn Vernon", "Implementing Domain Driven Desing"));

        // when -> I get all books
        // then -> I can see 2 two books'

        //when -> I add book with data:"Analysis Patterns"-Martin Fowler'
        //then -> Book should be added

        // when -> I get all books
        // then -> I can see 3 books

        //when -> I get one book via ISBN
        //then -> I can see book details

        //when -> I delete book Fowler's book ISBN
        //then -> Last added book should be deleted

        //when -> I get all books
        //then -> I can see two books

        //when -> I get book instance via ISBN
        //then -> I get book instance data

        //when -> I add instance detail
        //then -> One instance should be added

        //when -> I delete  one instalnce
        //then -> Instance should be succesfully deleted

        //when -> I add new instance
        //then -> new book instance should be added

    }
}
