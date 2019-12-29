package mw.library.catalogue.inmemory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mw.library.catalogue.Book;
import mw.library.catalogue.BookInstance;
import mw.library.catalogue.CatalogueRepository;
import mw.library.catalogue.ISBN;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InMemoryCatalogueDatabase implements CatalogueRepository {

    private Map<ISBN, Book> books = new ConcurrentHashMap<>();
    private Map<ISBN, BookInstance> instances = new ConcurrentHashMap<>();

    @Override
    public Book saveNew(Book book) {
        return books.put(book.getBookISBN(), book);
    }

    @Override
    public BookInstance saveNew(BookInstance bookInstance) {

        return instances.put(bookInstance.getBookISBN(), bookInstance);
    }

    @Override
    public Optional<Book> findBy(ISBN isbn) {
        return books.values().stream().filter(it -> it.getBookISBN().equals(isbn)).findFirst();
    }
}
