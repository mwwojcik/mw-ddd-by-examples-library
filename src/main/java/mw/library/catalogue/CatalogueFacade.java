package mw.library.catalogue;

import java.util.List;
import java.util.Optional;

public interface CatalogueFacade {
    List<Book> findAllBooks();

    Book saveNew(Book book);

    Optional<Book> findBy(ISBN isbn);

    List<BookInstance>findInstancesByBookISBN(ISBN isbn);

    BookInstance saveNew(BookInstance bookInstance);

    void deleteBy(ISBN isbn);

    Optional<BookInstance> findInstanceBy(BookId isbn);

    void deleteInstanceBy(BookId isbn);
}
