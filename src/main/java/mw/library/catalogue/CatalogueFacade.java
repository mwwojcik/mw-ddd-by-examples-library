package mw.library.catalogue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CatalogueFacade {

    private CatalogueRepository repository;

    Book saveNew(Book book) {
        return repository.saveNew(book);
    }

    BookInstance saveNew(BookInstance bookInstance) {
        return repository.saveNew(bookInstance);
    }

    Optional<Book> findBy(ISBN isbn) {
        return repository.findBy(isbn);
    }

}
