package mw.library.catalogue.infrastructure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import mw.library.catalogue.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CatalogueFacadeBean implements mw.library.catalogue.CatalogueFacade {

    private CatalogueRepository repository;

    @Override
    public List<Book> findAllBooks() {
        return repository.findAllBooks();
    }
    @Override
    public Book saveNew(Book book) {
        return repository.saveNew(book);
    }
    @Override
    public Optional<Book> findBy(ISBN isbn) {
        return repository.findBy(isbn);
    }

    @Override
    public List<BookInstance>findInstancesByBookISBN(ISBN isbn){
        return repository.findBookInstancesBy(isbn);
    }

    @Override
    public BookInstance saveNew(BookInstance bookInstance) {
        return repository.saveNew(bookInstance);
    }

    @Override
    public void deleteBy(ISBN isbn) {
        repository.deleteBookBy(isbn);
    }

    @Override
    public Optional<BookInstance> findInstanceBy(BookId isbn) {
        return repository.findBookInstanceBy(isbn);
    }

    @Override
    public void deleteInstanceBy(BookId isbn) {
        repository.deleteBookInstanceBy(isbn);
    }

}
