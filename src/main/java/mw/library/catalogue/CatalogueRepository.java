package mw.library.catalogue;

import java.util.List;
import java.util.Optional;

public interface CatalogueRepository {
    List<Book> findAllBooks();

    Book saveNew(Book book);

    Optional<Book> findBy(ISBN isbn);

    void deleteBookBy(ISBN isbn);

    List<BookInstance> findBookInstancesBy(ISBN isbn);

    BookInstance saveNew(BookInstance bookInstance);

    Optional<BookInstance> findBookInstanceBy(BookId isbn);

    void deleteBookInstanceBy(BookId isbn);

}
