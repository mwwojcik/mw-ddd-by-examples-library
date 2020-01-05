package mw.library.catalogue.inmemory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mw.library.catalogue.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InMemoryCatalogueDatabase implements CatalogueRepository {

    private Map<ISBN, Book> books = new ConcurrentHashMap<>();
    private Map<BookId, BookInstance> instances = new ConcurrentHashMap<>();

    @Override
    public Book saveNew(Book book) {
        books.put(book.getBookISBN(), book);
        return books.get(book.getBookISBN());
    }

    @Override
    public BookInstance saveNew(BookInstance bookInstance) {
        instances.put(bookInstance.getBookId(), bookInstance);
        return instances.get(bookInstance.getBookId());

    }

    @Override
    public Optional<Book> findBy(ISBN isbn) {
        return books.values().stream().filter(it -> it.getBookISBN().equals(isbn)).findFirst();
    }

    @Override
    public List<Book> findAllBooks() {

        return books.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBookBy(ISBN isbn) {
        books.remove(isbn);
    }

    @Override
    public Optional<BookInstance> findInstanceBy(BookId bookId) {
        return Optional.of(instances.get(bookId));
    }

    @Override
    public List<BookInstance> findInstancesBy(ISBN isbn) {
        return instances.values().stream()
                .filter(i -> i.getBookISBN().equals(isbn))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteInstanceBy(BookId bookId) {
        instances.remove(bookId);
    }
}
