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
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveNew(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findBy(ISBN isbn) {
        return bookRepository.findByBookISBN(isbn);
    }

    @Override
    public void deleteBookBy(ISBN isbn) {
        bookRepository.deleteByBookISBN(isbn);
    }


    @Override
    public List<BookInstance> findBookInstancesBy(ISBN isbn) {
        return bookInstanceRepository.findByBookISBN(isbn);
    }

    @Override
    public BookInstance saveNew(BookInstance bookInstance) {
        return bookInstanceRepository.save(bookInstance);
    }

    @Override
    public Optional<BookInstance> findBookInstanceBy(BookId bookId) {
        return bookInstanceRepository.findByBookId(bookId);
    }

    @Override
    public void deleteBookInstanceBy(BookId bookId) {
        bookInstanceRepository.deleteByBookId(bookId);
    }
}
