package mw.library.catalogue.inmemory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mw.library.catalogue.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class InMemoryCatalogueDatabase implements CatalogueRepository {

    private Map<ISBN, Book> books = new ConcurrentHashMap<>();
    private Map<BookId, BookInstance> instances = new ConcurrentHashMap<>();

    @Override
    public Book saveNew(Book book) {
        return books.put(book.getBookISBN(), book);
    }

    @Override
    public BookInstance saveNew(BookInstance bookInstance) {

        return instances.put(new BookId(UUID.randomUUID()), bookInstance);
    }

    @Override
    public Optional<Book> findBy(ISBN isbn) {
        return books.values().stream().filter(it -> it.getBookISBN().equals(isbn)).findFirst();
    }

    @Override
    public List<Book> findAllBooks() {
        return books.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteBookBy(String isbn) {
        books.remove(new ISBN(isbn));
    }

    @Override
    public List<BookInstance> findInstancesBy(ISBN isbn) {
        var found = instances.values().stream().filter(it -> it.getBookISBN().getIsbn().equals(isbn)).collect(Collectors.toList());
        return found;
    }

    @Override
    public void deleteInstanceBy(String isbn) {
        var bookIds =
                instances.values().stream().filter(b -> b.getBookISBN().getIsbn().equals(isbn))
                        .map(b -> b.getBookId()).collect(Collectors.toList());

        bookIds.forEach(it ->
                instances.remove(it)
        );

    }
}
