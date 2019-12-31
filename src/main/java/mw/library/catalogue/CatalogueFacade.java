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

    public Optional<Book> findBy(ISBN isbn) {
        return repository.findBy(isbn);
    }

    public void deleteBy(ISBN isbn) {
        repository.deleteBookBy(isbn);
    }

    public List<Book> findAllBooks() {
        return repository.findAllBooks();
    }

    public BookInstance saveNew(BookInstance bookInstance) {
        return repository.saveNew(bookInstance);
    }

    public List<BookInstance>findInstancesByBookISBN(ISBN isbn){
        return repository.findInstancesBy(isbn);
    }

    public BookInstance findInstancesBy(BookId isbn) {
        return repository.findInstancesBy(isbn);
    }

    public void deleteInstanceBy(BookId isbn) {
        repository.deleteInstanceBy(isbn);
    }

}
