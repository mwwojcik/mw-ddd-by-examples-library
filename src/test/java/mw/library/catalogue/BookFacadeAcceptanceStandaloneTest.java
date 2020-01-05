package mw.library.catalogue;


import mw.library.catalogue.inmemory.CatalogueConfigurationInMemory;
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
class BookFacadeAcceptanceStandaloneTest {

    @Autowired
    CatalogueFacade facade;// = CatalogueConfigurationInMemory.catalogueFacade();

    @DisplayName("In memory test")
    @Test
    void acceptanceTestInMemory() throws Exception {
        // given inventory with two books added
        // "Domain-Driven Design" - Eric Evans, "Implementing Domain Driven Desing" - Vaughn Vernon
        var evans = facade.saveNew(new Book(BooksFixture.DDD_ISBN_STR, "Eric Evans", "Domain-Driven Design"));
        var vernon = facade.saveNew(new Book(BooksFixture.DDD_ISBN_STR_01, "Vaughn Vernon", "Implementing Domain Driven Desing"));

        // when -> I get all books
        var result = facade.findAllBooks();
        // then -> I can see 2 two books'
        assertThat(result).size().isEqualTo(2);
        //when -> I add book with data:"Analysis Patterns"-Martin Fowler'
        var addResult = facade.saveNew(new Book(BooksFixture.DDD_ISBN_STR_02, "Martin Fowler", "Analysis Patterns"));
        //then -> Book should be added
        assertThat(addResult).isNotNull();

        // when -> I get all books
        var resAllThree = facade.findAllBooks();
        // then -> I can see 3 books
        assertThat(resAllThree).size().isEqualTo(3);

        //when -> I get one book via ISBN
        var res = facade.findBy(new ISBN(BooksFixture.DDD_ISBN_STR_02));
        //then -> I can see book details
        assertThat(res).isNotEmpty();


        //when -> I delete book Fowler's book ISBN
        facade.deleteBy(new ISBN(BooksFixture.DDD_ISBN_STR_02));

        // when -> I get all books
        var resOnlyTwo = facade.findAllBooks();
        // then -> I can see 2 two books'
        assertThat(result).size().isEqualTo(2);

        //when -> I add instance detail
        var evansInstRes = facade.saveNew(BookInstance.of(evans, BookType.Typical));
        //then -> One instance should be added
        assertThat(evansInstRes).isNotNull();
        assertThat(evansInstRes.getBookId()).isNotNull();

        //when
        var evansAllInst=facade.findInstancesByBookISBN(evans.getBookISBN());
        //then
        assertThat(evansAllInst).isNotEmpty();

        //when -> I delete  one instalnce
        facade.deleteInstanceBy(evansInstRes.getBookId());
        //then -> Instance should be succesfully deleted
        var resAfterDel = facade.findInstanceBy(evansInstRes.getBookId());
        assertThat(resAfterDel).isNull();
    }
}
