package mw.library.catalogue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CatalogueFacade {

    private CatalogueRepository repository;

    public List<Book> findAllBooks() {
        return repository.findAllBooks();
    }
    public Book saveNew(Book book) {
        return repository.saveNew(book);
    }
    public Optional<Book> findBy(ISBN isbn) {
        return repository.findBy(isbn);
    }

    public List<BookInstance>findInstancesByBookISBN(ISBN isbn){
        return repository.findBookInstancesBy(isbn);
    }

    public BookInstance saveNew(BookInstance bookInstance) {
        return repository.saveNew(bookInstance);
    }

    public void deleteBy(ISBN isbn) {
        repository.deleteBookBy(isbn);
    }

    public Optional<BookInstance> findInstanceBy(BookId isbn) {
        return repository.findBookInstanceBy(isbn);
    }

    public void deleteInstanceBy(BookId isbn) {
        repository.deleteBookInstanceBy(isbn);
    }

}
