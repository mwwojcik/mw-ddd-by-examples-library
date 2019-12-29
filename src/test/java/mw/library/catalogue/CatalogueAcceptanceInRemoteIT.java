package mw.library.catalogue;


import mw.library.catalogue.remote.LibraryManagementRemoteTestApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LibraryManagementRemoteTestApp.class)
class CatalogueAcceptanceInRemoteIT {
    @Autowired
    private CatalogueFacade facade;

    @DisplayName("Positive test acceptance - add book to catalogue")
    @Test
    void acceptanceTestInRemoteDB()
            throws Exception {

        // given inventory with two books added
        // "Domain-Driven Design" - Eric Evans, "Implementing Domain Driven Desing" - Vaughn Vernon
        var evans = facade.saveNew(new Book(BooksFixture.DDD_ISBN_STR, "Eric Evans", "Domain-Driven Design"));
        var vernon = facade.saveNew(new Book(BooksFixture.DDD_ISBN_STR_01, "Vaughn Vernon", "Implementing Domain Driven Desing"));
        //each book has one restricted instance
        facade.saveNew(BookInstance.of(evans, BookType.Typical));
        facade.saveNew(BookInstance.of(vernon, BookType.Typical));

        // when -> I go api/books
        // then -> I can see 2 films'

        //when -> I post api/books wit data:"Analysis Patterns"-Martin Fowler'
        //then -> I can see added book data

        // when -> I go api/books
        // then -> I can see 3 films

        //when -> I get /api/books/ISBN
        //then -> I can see book details

        //when -> I delete /api/books with Fowler's book ISBN
        //then -> Last added book should be deleted

        //when -> I go api/books
        //then -> I can see two books

        //when -> I get /api/books/instance/ISBN
        //then -> I get book instance data

        //when -> I post /api/books/instance/ID
        //then -> I can see instance details

        //when -> I delete  /api/books/instance/ID
        //then -> Instance should be succesfully deleted

        //when -> I post on /api/books/instance/ISBN
        //then -> new book instance should be added
    }
}
