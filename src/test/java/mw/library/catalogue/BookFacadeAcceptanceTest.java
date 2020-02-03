package mw.library.catalogue;

import mw.library.catalogue.infrastructure.CatalogueFacadeBean;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

abstract class  BookFacadeAcceptanceTest {

    protected abstract CatalogueFacadeBean getFacade();
    
    protected void acceptance() {
        // given inventory with two books added
        // "Domain-Driven Design" - Eric Evans, "Implementing Domain Driven Desing" - Vaughn Vernon
        var evans = getFacade().saveNew(new Book(BooksFixture.DDD_ISBN_STR, "Eric Evans", "Domain-Driven Design"));
        var vernon = getFacade().saveNew(new Book(BooksFixture.DDD_ISBN_STR_01, "Vaughn Vernon", "Implementing Domain Driven Desing"));

        // when -> I get all books
        var result = getFacade().findAllBooks();
        // then -> I can see 2 two books'
        Assertions.assertThat(result).size().isEqualTo(2);
        //when -> I add book with data:"Analysis Patterns"-Martin Fowler'
        var addResult = getFacade().saveNew(new Book(BooksFixture.DDD_ISBN_STR_02, "Martin Fowler", "Analysis Patterns"));
        //then -> Book should be added
        Assertions.assertThat(addResult).isNotNull();

        // when -> I get all books
        var resAllThree = getFacade().findAllBooks();
        // then -> I can see 3 books
        Assertions.assertThat(resAllThree).size().isEqualTo(3);

        //when -> I get one book via ISBN
        var res = getFacade().findBy(new ISBN(BooksFixture.DDD_ISBN_STR_02));
        //then -> I can see book details
        Assertions.assertThat(res).isNotEmpty();


        //when -> I delete book Fowler's book ISBN
        getFacade().deleteBy(new ISBN(BooksFixture.DDD_ISBN_STR_02));

        // when -> I get all books
        var resOnlyTwo = getFacade().findAllBooks();
        // then -> I can see 2 two books'
        Assertions.assertThat(result).size().isEqualTo(2);

        //when -> I add instance detail
        var evansInstRes = getFacade().saveNew(BookInstance.of(evans, BookType.Typical));
        //then -> One instance should be added
        Assertions.assertThat(evansInstRes).isNotNull();
        Assertions.assertThat(evansInstRes.getBookId()).isNotNull();

        //when
        var evansAllInst=getFacade().findInstancesByBookISBN(evans.getBookISBN());
        //then
        Assertions.assertThat(evansAllInst).isNotEmpty();

        //when -> I delete  one instalnce
        getFacade().deleteInstanceBy(evansInstRes.getBookId());
        //then -> Instance should be succesfully deleted
        var resAfterDel = getFacade().findInstanceBy(evansInstRes.getBookId());
        Assertions.assertThat(resAfterDel).isEmpty();
    }
}
