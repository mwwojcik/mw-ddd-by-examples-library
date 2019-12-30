package mw.library.catalogue.infrastructure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import mw.library.catalogue.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class CatalogueDatabase implements CatalogueRepository {
    private CatalogueBookMongoRepository bookRepository;
    private CatalogueBookInstMongoRepository bookInstanceRepository;

    @Override
    public Book saveNew(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public BookInstance saveNew(BookInstance bookInstance) {
        return bookInstanceRepository.save(bookInstance);
    }

    @Override
    public Optional<Book> findBy(ISBN isbn) {
        return bookRepository.findById(isbn);
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public void deleteBookBy(ISBN isbn) {

    }

    @Override
    public BookInstance findInstancesBy(BookId isbn) {
        return null;//Collections.emptyList();
    }

    @Override
    public void deleteInstanceBy(BookId isbn) {

    }
}
