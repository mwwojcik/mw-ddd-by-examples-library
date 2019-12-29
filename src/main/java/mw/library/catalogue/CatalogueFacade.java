package mw.library.catalogue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CatalogueFacade {

    private CatalogueRepository repository;

    public Book saveNew(Book book) {
        return repository.saveNew(book);
    }

    public BookInstance saveNew(BookInstance bookInstance) {
        return repository.saveNew(bookInstance);
    }

    public Optional<Book> findBy(ISBN isbn) {
        return repository.findBy(isbn);
    }

    public List<Book> findAllBooks() {
        return null;
    }

    public void deleteBy(String isbn) {

    }
}
