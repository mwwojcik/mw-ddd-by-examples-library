package mw.library.catalogue;

import java.util.List;
import java.util.Optional;

public interface CatalogueRepository {
    Book saveNew(Book book);

    BookInstance saveNew(BookInstance bookInstance);

    Optional<Book> findBy(ISBN isbn);

    List<Book> findAllBooks();

    void deleteBookBy(String isbn);

    List<BookInstance> findInstancesBy(ISBN isbn);

    void deleteInstanceBy(String isbn);
}
