package mw.library.catalogue.infrastructure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import mw.library.catalogue.Book;
import mw.library.catalogue.BookInstance;
import mw.library.catalogue.CatalogueRepository;
import mw.library.catalogue.ISBN;

import java.util.Optional;
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class CatalogueDatabase implements CatalogueRepository {
    private  CatalogueBookMongoRepository bookRepository;
    private CatalogueBookInstMongoRepository bookInstanceRepository;

    @Override
    public Book saveNew(Book book) {
        return null;
    }

    @Override
    public BookInstance saveNew(BookInstance bookInstance) {
        return null;
    }

    @Override
    public Optional<Book> findBy(ISBN isbn) {
        return Optional.empty();
    }
}
