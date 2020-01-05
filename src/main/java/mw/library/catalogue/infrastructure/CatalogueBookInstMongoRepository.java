package mw.library.catalogue.infrastructure;

import mw.library.catalogue.BookId;
import mw.library.catalogue.BookInstance;
import mw.library.catalogue.ISBN;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

interface CatalogueBookInstMongoRepository extends MongoRepository<BookInstance, BookId> {

    List<BookInstance> findByBookISBN(ISBN isbn);

    Optional<BookInstance> findByBookId(BookId bookId);

    void deleteByBookId(BookId bookId);
}
