package mw.library.catalogue.infrastructure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import mw.library.catalogue.*;

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
        return bookRepository.findAll();
    }

    @Override
    public void deleteBookBy(ISBN isbn) {
        bookRepository.deleteById(isbn);
    }

    @Override
    public Optional<BookInstance> findInstanceBy(BookId isbn) {
        return bookInstanceRepository.findById(isbn);//Collections.emptyList();
    }

    @Override
    public List<BookInstance> findInstancesBy(ISBN isbn) {
        return null;
    }

    @Override
    public void deleteInstanceBy(BookId isbn) {

    }
}
