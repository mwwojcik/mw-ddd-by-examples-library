package mw.library.catalogue;

import java.util.List;
import java.util.Optional;

public interface CatalogueRepository {
    Book saveNew(Book book);
    Optional<Book> findBy(ISBN isbn);
    List<Book> findAllBooks();
    void deleteBookBy(ISBN isbn);

    BookInstance saveNew(BookInstance bookInstance);
    BookInstance findInstancesBy(BookId isbn);
    List<BookInstance> findInstancesBy(ISBN isbn);
    void deleteInstanceBy(BookId isbn);

}
