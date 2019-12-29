package mw.library.catalogue;

import java.util.Optional;

public interface CatalogueRepository {
    Book saveNew(Book book);
    BookInstance saveNew(BookInstance bookInstance);
    Optional<Book> findBy(ISBN isbn);
}
